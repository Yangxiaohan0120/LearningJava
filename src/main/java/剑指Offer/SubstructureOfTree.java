package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-07-27 17:18
 **/
public class SubstructureOfTree {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!=null) && (isSame(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    public boolean isSame(TreeNode l, TreeNode r) {
        if (r == null) return true;
        if (l == null || l.val != r.val) return false;
        return isSame(l.left, r.left) && isSame(l.right, r.right);
    }


}
