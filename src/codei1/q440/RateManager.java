package codei1.q440;

import java.util.ArrayList;
import java.util.List;

/**
 * Rate処理
 * ユーザ毎のRateとアイテム毎のRate,
 * それぞれをとってこれるようにする
 */
public class RateManager {
    List<Rate> rateList = new ArrayList<Rate>();
    int maxItemId = 0;
    int maxUserId = 0;

    public void add(Rate rate) {
        rateList.add(rate);
        if (maxItemId < rate.getItemId())
            maxItemId = rate.getItemId();
        if (maxUserId < rate.getUserId())
            maxUserId = rate.getUserId();
    }

    public List<Rate> findRatesByUserId(int userId) {
        return findRates(userId, new IdGettable() {
            @Override
            public int getId(Rate rate) {
                return rate.getUserId();
            }
        });
    }

    public List<Rate> findRatesByItemId(int itemId) {
        return findRates(itemId, new IdGettable() {
            @Override
            public int getId(Rate rate) {
                return rate.getItemId();
            }
        });
    }

    public int getItemSize() {
        return maxItemId;
    }

    public int getUserSize() {
        return maxUserId;
    }

    private List<Rate> findRates(int id, IdGettable getIdWay) {
        List<Rate> retList = new ArrayList<Rate>();
        for (Rate rate : rateList) {
            if (getIdWay.getId(rate) == id)
                retList.add(rate);
        }
        return retList;
    }
}
