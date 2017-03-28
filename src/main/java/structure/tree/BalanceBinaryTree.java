package structure.tree;

import structure.tree.test.TreeReBuilderTest;

/**
 * 平衡二叉树的一些工具方法
 * <p>
 * Created by liumian on 2017/3/28.
 */
public class BalanceBinaryTree {


    /**
     * 自上向下遍历各个节点（类似于前序遍历），当存在高度差大于1的时候返回false
     * 这种方法会重复计算已经计算过的节点，效率比较低
     *
     * @param root
     * @return
     */
    public boolean isBalanceTreeFromTop(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = getTreeDepthFor(root.left, 0);
        int right = getTreeDepthFor(root.right, 0);
        int diff = left > right ? left - right : right - left;
        if (diff > 1) {
            return false;
        } else {
            return isBalanceTreeFromTop(root.left) && isBalanceTreeFromTop(root.right);
        }
    }


    private int getTreeDepthFor(TreeNode root, int depth) {

        int left;
        if (root.left == null) {
            return depth;
        } else {
            left = getTreeDepthFor(root.left, depth++);
        }

        int right;

        if (root.right == null) {
            return depth;
        } else {
            right = getTreeDepthFor(root.right, depth++);
        }

        return left > right ? left : right;

    }


    /**
     * 自下向上遍历（相当于后序遍历），当检测到存在不平衡的子树马上返回false。
     *
     * @param root
     * @param depth 当前节点左右子树的深度，数组中只有一个元素，用于记录当前节点的高度
     * @return
     */
    public boolean isBalanceTreeFromBottom(TreeNode root, int[] depth) {

        if (root == null) {
            return true;
        }
        int[] left = {depth[0]};
        int[] right = {depth[0]};
        if (isBalanceTreeFromBottom(root.left, left)
                && isBalanceTreeFromBottom(root.right, right)) {
            if (root.left != null) {
                left[0]++;
            }

            if (root.right != null) {
                right[0]++;
            }

            int diff = left[0] > right[0] ? left[0] : right[0];
            if (diff > 1) {
                return false;
            } else {
                depth[0] = left[0] > right[0] ? left[0] : right[0];
                return true;
            }

        }

        return false;

    }


    public static void main(String[] args) {

        TreeNode root = TreeReBuilderTest.buildTestTree();

        BalanceBinaryTree tree = new BalanceBinaryTree();
        System.out.println(tree.isBalanceTreeFromTop(root));

        int[] depth = {0};
        System.out.println(tree.isBalanceTreeFromBottom(root, depth));


    }


}
