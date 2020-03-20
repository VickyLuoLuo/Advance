package advance.tree;

import java.util.Stack;

/**
 * 中序遍历，左->中->右
 */
public class InOrderTraverse {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
//        inOrderTraverse(root);
        inOrderTraverse2(root);
    }

    // 递归
    public static void inOrderTraverse(TreeNode node) {
        if (null != node) {
            inOrderTraverse(node.left);
            System.out.print(node.data + " ");
            inOrderTraverse(node.right);
        }
    }

    // 非递归
    public static void inOrderTraverse2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (null != node || !stack.empty()) {
            if (null != node) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                System.out.print(tem.data + " ");
                node = tem.right;
            }
        }
    }
}