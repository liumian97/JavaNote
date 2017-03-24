package structure.test;

import structure.TreeNode;
import structure.TreeReBuilder;

import java.util.*;

/**
 * Created by liumian on 2017/3/24.
 */
public class TreeReBuilderTest {


    public static void main(String[] args) {

        List<TreeNode> preOrder = new ArrayList<>();
        preOrder.add(new TreeNode(1));
        preOrder.add(new TreeNode(2));
        preOrder.add(new TreeNode(4));
        preOrder.add(new TreeNode(5));
        preOrder.add(new TreeNode(6));
        preOrder.add(new TreeNode(3));
        preOrder.add(new TreeNode(7));

        List<TreeNode> inOrder = new ArrayList<>();
        inOrder.add(new TreeNode(4));
        inOrder.add(new TreeNode(2));
        inOrder.add(new TreeNode(6));
        inOrder.add(new TreeNode(5));
        inOrder.add(new TreeNode(1));
        inOrder.add(new TreeNode(3));
        inOrder.add(new TreeNode(7));

        TreeReBuilder rereBuilder = new TreeReBuilder();

        TreeNode root = rereBuilder.rebuild(preOrder, inOrder);
        printTreeByLevel(root);
        System.out.println("this is 分割线-----------");
        dsf(root);

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
    public static void dsf(TreeNode root) {

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
