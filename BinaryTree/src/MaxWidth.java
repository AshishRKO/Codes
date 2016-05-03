
public class MaxWidth 
{
	// A utility function to get height of a binary tree
	public static int height(TreeNode root)
	{
		if(root==null)
			return 0;

		int l=height(root.left);
		int r=height(root.right);

		return Math.max(l,r)+1;
	}
	
	/* Function to get the maximum width of a binary tree*/
	/* n this method we create a temporary array count[] of size equal to the height of tree. 
	 * We initialize all values in count as 0. 
	 * We traverse the tree using preorder traversal and fill the entries in count 
	 * so that the count array contains count of nodes at each level in Binary Tree.
	 */
	//Time Complexity: O(n)
	public static int getMaxWidth(TreeNode root)
	{
		int h=height(root);
		int a[]=new int[h];
		
		helper(root, a ,0);
		
		// getting the maximum element of the array
		int max=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(max<a[i])
				max=a[i];
		}
		return max;
	}
	
	// A function that fills count array with count of nodes at every
	// level of given binary tree
	public static void helper(TreeNode root, int a[], int level)
	{
		if(root==null)
			return ;
		
		a[level]++;
		helper(root.left,a,level+1);
		helper(root.right,a,level+1);
	}
	
	// Method 2- Use level order traversal to count nodes in every level and get the maximum
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		  TreeNode root = new TreeNode(1);
		  root.left        = new TreeNode(2);
		  root.right       = new TreeNode(3);
		  root.left.left  = new TreeNode(4);
		  root.left.right = new TreeNode(5);
		  root.right.right = new TreeNode(8);
		  root.right.right.left  = new TreeNode(6);
		  root.right.right.right  = new TreeNode(7);
		 
		  /*
		   Constructed binary tree is:
		          1
		        /  \
		       2    3
		     /  \     \
		    4   5     8
		              /  \
		             6   7
		  */
		  System.out.println("Maximum width is "+getMaxWidth(root));

	}

}
