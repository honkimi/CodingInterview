package code.chap4;

public class Tree {
    public TreeNode root;
    public TreeNode current;

    public Tree(Object data) {
        this.root = new TreeNode(data);
        this.current = this.root;
    }

    public void moveLeft() {
        if (current.left != null) {
            current = current.left;
        }
    }

    public void moveRight() {
        if (current.right != null) {
            current = current.right;
        }
    }

    public void moveParent() {
        if (current != root) {
            current = current.parent;
        }
    }

}
