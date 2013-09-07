package codei1.q440;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 類似度計算
 */
public class CosInSimilarity {
    private RateManager mng;
    public CosInSimilarity(RateManager mng) {
        this.mng = mng;
    }

    /**
     * アイテムの一つずつに対し、どれが一番類似度が高いかを求める
     */
    public HashMap<Integer, Integer> calc() {
        HashMap<Integer, Integer> ret = new LinkedHashMap<Integer, Integer>();
        int itemSize = mng.getItemSize();
        double maxSimilar;
        int maxSimilarItemId = 0;
        double similar;
        for (int i = 1; i < itemSize + 1; i++) {
            maxSimilarItemId = 0;
            maxSimilar = 0;
            for (int j = 1; j < itemSize + 1; j++) {
                if (i == j) {
                    continue;
                }
                similar = calcSimilar(i, j);
                if (maxSimilar < similar) {
                    maxSimilar = similar;
                    maxSimilarItemId = j;
                }
            }
            ret.put(i,maxSimilarItemId);
        }
        return ret;
    }

    /**
     * Item(i) と Item(j)の類似度計算
     */
    private double calcSimilar(int i, int j) {
        List<Rate> iRates = mng.findRatesByItemId(i);
        List<Rate> jRates = mng.findRatesByItemId(j);
        double under = calcUnder(iRates, jRates);
        double upper =calcUpper(iRates, jRates);

        return upper / under;
    }

    /**
     * 類似度の分母の計算
     */
    private double calcUnder(List<Rate> iRates, List<Rate> jRates) {
        double iSquareSum = squareSum(iRates);
        double jSquareSum = squareSum(jRates);
        return Math.sqrt(iSquareSum) * Math.sqrt(jSquareSum);
    }

    private double squareSum(List<Rate> rateList) {
        double total = 0;
        for (Rate rate: rateList) {
            for (int rat : rate.getRates()) {
                total += Math.pow(rat, 2);
            }
        }
        return total;
    }

    /**
     * 類似度の分子の計算
     * 4    5   20
     * 4    5   1
     * の時ってどうなるのか・・。
     */
    private double calcUpper(List<Rate> iRates, List<Rate> jRates) {
        int userSize = mng.getUserSize();
        double total = 0;
        int a, b;
        for (int i = 0; i < userSize; i++) {
            a = 0;
            b = 0;
            for(int rate : iRates.get(i).getRates()) {
                a = rate;
            }
            for(int rate : jRates.get(i).getRates()) {
                b = rate;
            }
            total += a * b;
        }
        return total;
    }
}
