package code.chap4;

/**
 * �����Ƀ\�[�g���ꂽ�z�񂪗^����ꂽ�Ƃ��A�������ŏ��ɂȂ�񕪒T���؂����
 * �A���S���Y���������Ă��������B
 *
 * @author kiminari.homma
 *
 */
public class Q3 {

    /**
     * �������ŏ��ɂȂ�2���T���؂̍쐬
     * @param data
     * @return root �̃m�[�h
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

        // ���������ɒǉ�����f�[�^������΁A�����̒���������left�ɒǉ�
        int leftCenter = center / 2;
        if ( leftCenter >= 0) {
            treeNode.appendLeft(data[leftCenter]);
            makeBinTree(treeNode.left, makeData(0, center - 1, data));
        }
        // �����E���ɒǉ�����f�[�^������΁A�E���̒���������right�ɒǉ�
        int rightCenter = (center + n) / 2;
        if (rightCenter > center) {
            treeNode.appendRight(data[rightCenter]);
            makeBinTree(treeNode.right, makeData(center + 1, n - 1, data));
        }
    }

    /**
     * �z����̃f�[�^�������s�� array[start..end] �I�ȃ��\�b�h
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
