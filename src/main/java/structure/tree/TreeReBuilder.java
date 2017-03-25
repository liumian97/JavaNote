package structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * rebuild binary tree by preOrder and inOrder
 * postOrder will be support later
 *
 * Created by liumian on 2017/3/24.
 */
public class TreeReBuilder {

    public TreeNode rebuild(List<TreeNode> preOrder, List<TreeNode> inOrder) {

        if (preOrder == null || preOrder.size() == 0) {
            return null;
        }

        TreeNode root = preOrder.get(0);
        int indexOfRoot = inOrder.indexOf(root);

        preOrder.remove(0);

        //检查是否左边溢出 - 》 构建左子树
        if (indexOfRoot > 0) {
            List<TreeNode> leftOfInOrder = inOrder.subList(0, indexOfRoot);
            root.left = rebuild(preOrder, leftOfInOrder);
        }
        //检查右边是否溢出 - 》 构建右子树
        if (indexOfRoot + 1 < inOrder.size()) {
            List<TreeNode> rightOfInOrder = inOrder.subList(indexOfRoot + 1, inOrder.size());
            root.right = rebuild(preOrder, rightOfInOrder);
        }

        return root;

    }


    public TreeNode buildTestTree(){
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

        return reBuilder.rebuild(preOrder, inOrder);
    }

}
