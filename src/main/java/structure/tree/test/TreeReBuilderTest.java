package structure.tree.test;

import structure.tree.TreeNode;
import structure.tree.TreeReBuilder;

import java.util.*;

import static structure.tree.TreeNode.depthFirstSearch;
import static structure.tree.TreeNode.printTreeByLevel;

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

        TreeReBuilder reBuilder = new TreeReBuilder();

        TreeNode root = reBuilder.rebuild(preOrder, inOrder);
        printTreeByLevel(root);
        System.out.println("this is 分割线-----------");
        depthFirstSearch(root);

    }






}
