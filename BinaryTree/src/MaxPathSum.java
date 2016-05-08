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
public class MaxPathSum 
{
	
	int max;
    public int maxPathSum(TreeNode root) 
    {
        max=Integer.MIN_VALUE;
        helper(root);  
        return max;
    }
    
    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        if(left<0)
            left=0;
        if(right<0)
            right=0;
        if(left+right+root.data>max)
            max=left+right+root.data;
        
        // Returning whether left subtree is bigger or right subtree
        return root.data+Math.max(left,right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
