package structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * rebuild binary tree by preOrder and inOrder
 * postOrder will be support later
 * <p>
 * Created by liumian on 2017/3/24.
 */
public class TreeReBuilder {

    public TreeNode rebuild(List<TreeNode> preOrder, List<TreeNode> inOrder) throws Exception {

        if (preOrder == null || inOrder == null) {
            return null;
        }

        if (preOrder.size() == 0 && inOrder.size() != 0) {
            throw new Exception("输入的前序、后序遍历的数据有误，不能重构二叉树");
        }

        TreeNode root = preOrder.get(0);
        int indexOfRoot = inOrder.indexOf(root);


        if (indexOfRoot == -1) {
            throw new Exception("输入的前序、后序遍历的数据有误，不能重构二叉树");
        }

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


}
