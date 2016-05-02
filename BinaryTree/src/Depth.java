
public class Depth 
{
	public static int minDepth(TreeNode root) 
    {
        if(root==null)
			return 0;
			
		if(root.left==null)
		    return 1+minDepth(root.right);
		if(root.right==null)
		    return 1+minDepth(root.left);

		int l=minDepth(root.left);
		int r=minDepth(root.right);

		return Math.min(l,r)+1;    
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
