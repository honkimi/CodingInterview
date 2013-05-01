package code.chap4;

/**
 * 二分木が平衡かどうかを調べる関数を実装してください。 平衡木とは、どのノードの2つの部分木も、その高さの差が1以下であるような木であると定義します。
 *
 * @author kiminari.homma
 *
 */
public class Q1 {
    static int maxDeep;
    static int minDeep;
    static int currentDeep;

    public static boolean isBalancedTree(Tree tree) {
        initDeep();
        searchLeaf(tree.root, 0);
        System.out.println("maxDeep:" + maxDeep);
        System.out.println("minDeep:" + minDeep);
        int result = maxDeep - minDeep;
        if ( result > 1) {
            return false;
        }
        return true;
    }

    private static void initDeep() {
        maxDeep = 0;
        minDeep = 999;
        currentDeep = 0;
    }

    private static void searchLeaf(TreeNode treeNode, int deep) {
        System.out.println("data:" + treeNode.data);
        System.out.println("deep:" + deep);
        if (treeNode.isLeaf()) {
            if (deep > maxDeep) {
                maxDeep = deep;
            }
            if (deep < minDeep) {
                minDeep = deep;
            }
            return;
        }

        if (treeNode.left != null) {
            searchLeaf(treeNode.left, deep + 1);
        }
        if (treeNode.right != null) {
            searchLeaf(treeNode.right, deep + 1);
        }

    }

}
