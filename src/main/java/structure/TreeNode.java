package structure;

/**
 * Created by liumian on 2017/3/24.
 */
public class TreeNode {

    public int value;

    public TreeNode left,right;


    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        return value == treeNode.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
