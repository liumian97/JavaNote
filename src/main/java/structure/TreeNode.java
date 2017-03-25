package structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by liumian on 2017/3/24.
 */
public class TreeNode {

    public int value;

    public TreeNode left,right;


    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        return value == treeNode.value;
    }

    @Override
    public int hashCode() {
        return value;
    }


    /**
     * 层序遍历
     * @param root
     */
    public static void printTreeByLevel(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            System.out.println(node.value);

        }

    }


    /**
     * 深度优先遍历
     * @param root
     */
    public static void depthFirstSearch(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
