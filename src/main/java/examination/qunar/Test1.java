package examination.qunar;


import java.util.*;

/**
 * 按层打印二叉树
 * <p>
 * Created by liumian on 2017/4/1.
 */
public class Test1 {

    static class TreeNode {
        TreeNode left, right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TreeNode treeNode = (TreeNode) o;

            return value == treeNode.value;
        }

        public int hashCode() {
            return value;
        }

    }

    public static TreeNode rebuild(List<TreeNode> preOrder, List<TreeNode> inOrder) throws Exception {

        if (preOrder == null || inOrder == null || preOrder.size() == 0) {
            return null;
        }

//        if (preOrder.size() == 0 && inOrder.size() != 0) {
//            throw new Exception("输入的前序、后序遍历的数据有误，不能重构二叉树");
//        }

        TreeNode root = preOrder.get(0);
        int indexOfRoot = inOrder.indexOf(root);


//        if (indexOfRoot == -1) {
//            throw new Exception("输入的前序、后序遍历的数据有误，不能重构二叉树");
//        }

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

    public static void printTreeByLevel(TreeNode root) {

        if (root == null) {
            return;
        }
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

            System.out.print(node.value + " ");

        }

    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        List<TreeNode> preOrder = new ArrayList<>();
        List<TreeNode> inOrder = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            preOrder.add(new TreeNode(scanner.nextInt()));
        }
        for (int i = 0; i < size; i++) {
            inOrder.add(new TreeNode(scanner.nextInt()));
        }

        TreeNode root = rebuild(preOrder, inOrder);
        printTreeByLevel(root);

    }


}
