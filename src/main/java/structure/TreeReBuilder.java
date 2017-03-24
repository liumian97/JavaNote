package structure;

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

        if (indexOfRoot > 0) {
            List<TreeNode> leftOfInOrder = inOrder.subList(0, indexOfRoot);
            root.left = rebuild(preOrder, leftOfInOrder);
        }

        if (indexOfRoot + 1 < inOrder.size()) {
            List<TreeNode> rightOfInOrder = inOrder.subList(indexOfRoot + 1, inOrder.size());
            root.right = rebuild(preOrder, rightOfInOrder);
        }

        return root;

    }

}
