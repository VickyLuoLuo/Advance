package advance.tree;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 前序遍历，中->左->右
 */
public class PreOrderTraverse {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
//        preOrderTraverse(root);
        preOrderTraverse2(root);
    }

    // 递归
    public static void preOrderTraverse(TreeNode node) {
        if (null != node) {
            System.out.print(node.data + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    // 非递归
    public static void preOrderTraverse2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (null != node || !stack.empty()) {
            if (null != node) {
                System.out.print(node.data + " ");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }
        }
    }
}