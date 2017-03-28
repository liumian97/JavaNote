package structure.tree.test;


import structure.tree.CommonNodeFinder;
import structure.tree.TreeNode;

/**
 * Created by liumian on 2017/3/25.
 */
public class CommonNodeFinderTest {


    public static void main(String[] args) {

        TreeNode root = TreeReBuilderTest.buildTestTree();

        CommonNodeFinder finder = new CommonNodeFinder();
        TreeNode commonNode = finder.findCommonNode(root,new TreeNode(6),new TreeNode(1));
        System.out.println(commonNode.value);


    }

}
