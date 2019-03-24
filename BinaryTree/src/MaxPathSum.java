/*
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
     
Return 6.
 */
class Res {
    public int val;
}
public class MaxPathSum {

    int max;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(-2);
        root.right = new TreeNode(-10);
        root.left.left = new TreeNode(-20);
        root.left.right = new TreeNode(-1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(-3);
        root.right.right.right = new TreeNode(4);

        MaxPathSum maxPathSum = new MaxPathSum();

        System.out.println(maxPathSum.maxPathSum(root));

        System.out.println(maxPathSum.findMaxSum(root));

    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        // getting current Max for root
        int currRootMax = Math.max(Math.max(left,right)+root.data, root.data);

        max = Math.max(max,currRootMax);

        // Returning whether left subtree is bigger or right subtree
        return currRootMax;
    }



    int findMaxUtil(TreeNode node, Res res)
    {

        // Base Case
        if (node == null)
            return 0;

        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.data,
                node.data);


        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);

        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);

        return max_single;
    }


    // Returns maximum path sum in tree with given root
    int findMaxSum(TreeNode node) {

        // Initialize result
        // int res2 = Integer.MIN_VALUE;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        // Compute and return result
        findMaxUtil(node, res);
        return res.val;
    }

}
