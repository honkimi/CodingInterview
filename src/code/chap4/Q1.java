package code.chap4;

/**
 * �񕪖؂����t���ǂ����𒲂ׂ�֐����������Ă��������B
 * ���t�؂Ƃ́A�ǂ̃m�[�h��2�̕����؂��A���̍����̍���1�ȉ��ł���悤�Ȗ؂ł���ƒ�`���܂��B
 *
 * �����̂���:
 * �ŏ���Deep�ƍő��Deep�����ꂼ�ꋁ�߂āA
 * �ŏI�I�ɂ��ꂪ1���傫�����ۂ��𔻕ʂ��A�����傫�����false��Ԃ��悤�Ȃ���B
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
     * �񓚕ҁB
     *
     * ���[�g����ċA�I�ɍ~�����Ȃ��獂���̃`�F�b�N���s���B���ꂼ��̃m�[�h�ŁA
     * ���E�̕����؂ɑ΂���checkHeight���ċA�I�ɌĂяo���č��������߂Ă����B�����؂�
     * ���t�łȂ���΁AcheckHeight��-1��Ԃ��悤�ɂ��Ă����B�����ČĂяo������-1���Ԃ��Ă���΁A
     * �����ɍċN�𔲂���悤�ɂ��Ă����B
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

        //�������؂̍����̎擾�B���̎��_��-1���Ԃ��Ă�����A
        //���t�؂ł͂Ȃ��̂ŁA-1��Ԃ�
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        //���������߂�B�����̍�����1���傫����΁A���̎��_�ŕ��t�؂ł͂Ȃ��B
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1; //not balanced
        } else {
            /* return height */
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
