package structure.tree;

/**
 * 寻找二叉树最低公共节点
 * <p>
 * Created by liumian on 2017/3/25.
 */
public class CommonNodeFinder {


    public TreeNode findCommonNode(TreeNode root, TreeNode targetA, TreeNode targetB) {

        if (root != null) {
            TreeNode headA = findLinkedNode(root, targetA);

            TreeNode headB = findLinkedNode(root, targetB);

            while (headA.left != null && headB.left != null && headA.left.equals(headB.left)) {
                headA = headA.left;
                headB = headB.left;
            }


            return headA;
        }

        return root;

    }


    /**
     * 查找从根节点到目标节点的链表
     * @param root
     * @param target
     * @return
     */
    private TreeNode findLinkedNode(TreeNode root, TreeNode target) {


        //用节点的左子树记录链表
        if (root.equals(target)) {
            return new TreeNode(root.value);
        }

        if (root.equals(target)) {
            return new TreeNode(root.value);
        }
        TreeNode temp = null;
        if (root.left != null) {
            temp = findLinkedNode(root.left, target);
            if (temp != null) {
                TreeNode head = new TreeNode(root.value);
                head.left = temp;
                return head;
            }
        }

        //如果在左子树找到了那么就不在右子树找了
        if ( root.right != null) {
            temp = findLinkedNode(root.right, target);
            if (temp != null) {
                TreeNode head = new TreeNode(root.value);
                head.left = temp;
                return head;
            }
        }

        return null;

    }

}
