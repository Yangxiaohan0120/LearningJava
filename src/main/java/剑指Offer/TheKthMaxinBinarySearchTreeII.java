package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-02 10:09
 **/
public class TheKthMaxinBinarySearchTreeII {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    // 从右至左搜索，直到k == 0，返回当前的根结点。
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
