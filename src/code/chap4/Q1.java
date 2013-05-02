package code.chap4;

/**
 * 二分木が平衡かどうかを調べる関数を実装してください。
 * 平衡木とは、どのノードの2つの部分木も、その高さの差が1以下であるような木であると定義します。
 *
 * 自分のやり方:
 * 最小のDeepと最大のDeepをそれぞれ求めて、
 * 最終的にそれが1より大きいか否かを判別し、もし大きければfalseを返すようなつくり。
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

    /**
     * 回答編。
     *
     * ルートから再帰的に降下しながら高さのチェックを行う。それぞれのノードで、
     * 左右の部分木に対してcheckHeightを再帰的に呼び出して高さを求めていく。部分木が
     * 平衡でなければ、checkHeightは-1を返すようにしておく。そして呼び出し元で-1が返ってくれば、
     * すぐに再起を抜けるようにしておく。
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        }
        return true;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0; // Hegiht 0
        }

        //左部分木の高さの取得。この時点で-1が返ってきたら、
        //平衡木ではないので、-1を返す
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        //高さを求める。高さの差分が1より大きければ、その時点で平衡木ではない。
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1; //not balanced
        } else {
            /* return height */
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
