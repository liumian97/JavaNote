package structure.test;

import structure.CommonNodeFinder;
import structure.TreeNode;
import structure.TreeReBuilder;

/**
 * Created by liumian on 2017/3/25.
 */
public class CommonNodeFinderTest {


    public static void main(String[] args) {

        TreeReBuilder reBuilder = new TreeReBuilder();
        TreeNode root = reBuilder.buildTestTree();

        CommonNodeFinder finder = new CommonNodeFinder();
        TreeNode commonNode = finder.findCommonNode(root,new TreeNode(6),new TreeNode(1));
        System.out.println(commonNode.value);


    }

}
