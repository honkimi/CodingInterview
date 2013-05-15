package code.chap4;

/**
 * 昇順にソートされた配列が与えられたとき、高さが最小になる二分探索木を作る
 * アルゴリズムを書いてください。
 *
 * @author kiminari.homma
 *
 */
public class Q3 {

    /**
     * 高さが最小になる2分探索木の作成
     * @param data
     * @return root のノード
     */
    public static TreeNode makeBinTree(int[] data) {
        int center = data.length / 2;
        TreeNode root = new TreeNode(data[center]);
        makeBinTree(root, data);

        return root;
    }

    private static void makeBinTree(TreeNode treeNode, int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        }

        int center = n / 2;

        // もし左側に追加するデータがあれば、左側の中央部分をleftに追加
        int leftCenter = center / 2;
        if ( leftCenter >= 0) {
            treeNode.appendLeft(data[leftCenter]);
            makeBinTree(treeNode.left, makeData(0, center - 1, data));
        }
        // もし右側に追加するデータがあれば、右側の中央部分をrightに追加
        int rightCenter = (center + n) / 2;
        if (rightCenter > center) {
            treeNode.appendRight(data[rightCenter]);
            makeBinTree(treeNode.right, makeData(center + 1, n - 1, data));
        }
    }

    /**
     * 配列内のデータ分割を行う array[start..end] 的なメソッド
     * @param start
     * @param end
     * @param data
     * @return
     */
    private static int[] makeData(int start, int end, int[] data) {
        int[] ret = new int[end - start + 1];

        int idx = 0;
        for (int i = start; i <= end; i++) {
            ret[idx] = data[i];
            idx++;
        }

        return ret;
    }

}
