package code.chap4;

import java.util.LinkedList;
import java.util.List;

/**
 * 二分探索木が与えられたとき、同じ深さのノード同士の連結リストを作るアルゴリズムを設計してください
 * たとえば深さDの木があるとき、D個の連結リストを作ることになります。
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
            // 対象ノードの左の子がいればキューに追加
            if (popped.treeNode.left != null) {
                queue.add(new DeepNode(popped.treeNode.left, popped.deep + 1));
            }
            // 対象ノードの右の子がいればキューに追加
            if (popped.treeNode.right != null) {
                queue.add(new DeepNode(popped.treeNode.right, popped.deep + 1));
            }

            if (sameDeepNodeList.size() - 1 == popped.deep) {
                // もし同じ深さなら、ノードの後ろに追加
                sameDeepNodeList.get(sameDeepNodeList.size() - 1).appendToTail(popped.treeNode.data);
            } else {
                // 違う深さならリストへ新たにノード追加
                sameDeepNodeList.add(new Node(popped.treeNode.data));
            }
        }
        return sameDeepNodeList;
    }
}
