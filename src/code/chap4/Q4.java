package code.chap4;

import java.util.LinkedList;
import java.util.List;

/**
 * �񕪒T���؂��^����ꂽ�Ƃ��A�����[���̃m�[�h���m�̘A�����X�g�����A���S���Y����݌v���Ă�������
 * ���Ƃ��ΐ[��D�̖؂�����Ƃ��AD�̘A�����X�g����邱�ƂɂȂ�܂��B
 *
 * @author kiminari.homma
 *
 */
public class Q4 {

    static class DeepNode {
        public TreeNode treeNode;
        public int deep;

        public DeepNode(TreeNode treeNode, int deep) {
            this.treeNode = treeNode;
            this.deep = deep;
        }
    }

    public static List<Node> makeSameDeepNodeInTree(TreeNode root) {
        List<Node> sameDeepNodeList = new LinkedList<Node>();
        LinkedList<DeepNode> queue = new LinkedList<DeepNode>();

        queue.add(new DeepNode(root, 0));
        sameDeepNodeList.add(new Node(root.data));

        while (!queue.isEmpty()) {
            DeepNode popped = queue.pop();
            // �Ώۃm�[�h�̍��̎q������΃L���[�ɒǉ�
            if (popped.treeNode.left != null) {
                queue.add(new DeepNode(popped.treeNode.left, popped.deep + 1));
            }
            // �Ώۃm�[�h�̉E�̎q������΃L���[�ɒǉ�
            if (popped.treeNode.right != null) {
                queue.add(new DeepNode(popped.treeNode.right, popped.deep + 1));
            }

            if (sameDeepNodeList.size() - 1 == popped.deep) {
                // ���������[���Ȃ�A�m�[�h�̌��ɒǉ�
                sameDeepNodeList.get(sameDeepNodeList.size() - 1).appendToTail(popped.treeNode.data);
            } else {
                // �Ⴄ�[���Ȃ烊�X�g�֐V���Ƀm�[�h�ǉ�
                sameDeepNodeList.add(new Node(popped.treeNode.data));
            }
        }
        return sameDeepNodeList;
    }
}
