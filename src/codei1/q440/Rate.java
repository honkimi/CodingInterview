package codei1.q440;

import java.util.LinkedList;
import java.util.List;

/**
 * Rateクラス
 * 同じユーザ、同じアイテムでもレートが複数ある場合がある模様..
 */
public class Rate {
    private int userId;
    private int itemId;
    private List<Integer> rates = new LinkedList<Integer>();

    public Rate(String userId, String itemId, String rate) {
        this.userId = Integer.valueOf(userId);
        this.itemId = Integer.valueOf(itemId);
        this.rates.add(Integer.valueOf(rate));
    }

    public int getUserId() {
        return userId;
    }

    public int getItemId() {
        return itemId;
    }

    public List<Integer> getRates() {
        return rates;
    }
}
