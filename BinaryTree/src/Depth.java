
public class Depth 
{
	public static int minDepth(TreeNode root) 
    {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        // When the tree is skewed Tree
        if(left == 0 || right == 0) 
            return left + right + 1;
        else // Same as maxDepth
            return Math.min(left,right) + 1;
    }

    public static int maxDepth(TreeNode root) 
    {
        if(root==null)
			return 0;

		int l=maxDepth(root.left);
		int r=maxDepth(root.right);

		return Math.max(l,r)+1;    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		//root.right.right=new TreeNode(5);

		System.out.println("Max Depth = "+maxDepth(root));
		System.out.println("Min Depth = "+minDepth(root));

	}

}
