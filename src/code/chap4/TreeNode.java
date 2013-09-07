package code.chap4;

public class TreeNode {
    public TreeNode left  = null;
    public TreeNode right = null;
    public TreeNode parent = null;
    public Object data;

    public TreeNode(Object data) {
        this.data = data;
    }

    public void appendLeft(Object data) {
        left = new TreeNode(data);
        left.parent = this;
    }

    public void appendRight(Object data) {
        right = new TreeNode(data);
        right.parent = this;
    }

    public boolean isLeaf() {
        return right == null && left ==null;
    }
}
