package advance.tree;

import java.util.Stack;

/**
 * 后序遍历，左->右->中
 */
public class PostOrderTraverse {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        postOrderTraverse(root);
    }

    // 递归
    public static void postOrderTraverse(TreeNode node) {
        if (null != node) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.data + " ");
        }
    }

    // 非递归
    public static void postOrderTraverse2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        // todo
    }
}