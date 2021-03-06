/*
Print nodes at k distance from root
Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.

For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
            1
          /   \
        2      3
      /  \    /
    4     5  8 
*/

public class NodesKDistance 
{
	public static void printKDistance(TreeNode root,int k)
	{
		if(root==null)
			return ;

		if(k==0)
		{
			System.out.print(root.data+" ");
		}
		printKDistance(root.left, k-1);
		printKDistance(root.right, k-1);

	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		  root.left        = new TreeNode(2);
		  root.right       = new TreeNode(3);
		  root.left.left  = new TreeNode(4);
		  root.left.right = new TreeNode(5);
		  root.right.left = new TreeNode(8);  
		  /* Constructed binary tree is
          1
        /   \
      2      3
    /  \    /
  4     5  8 
*/
		 
		  printKDistance(root, 2);

	}

}
