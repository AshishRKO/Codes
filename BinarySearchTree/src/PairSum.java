//Find a pair with given sum in a Balanced BST
/*
 * 
public class TreeNode 
{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data)
	{
		this.data=data;
	}
}

 */
import java.util.Stack;

public class PairSum 
{
	public static boolean isPairPresent(TreeNode root, int target)
	{
		if(root==null)
			return false;
		// Create two stacks. s1 is used for normal inorder traversal
	    // and s2 is used for reverse inorder traversal
		Stack<TreeNode> s1=new Stack<TreeNode>();
		Stack<TreeNode> s2=new Stack<TreeNode>();
		// done1, val1 and curr1 are used for normal inorder traversal using s1
	    // done2, val2 and curr2 are used for reverse inorder traversal using s2
		TreeNode curr1 = root;
		TreeNode curr2 = root;
		
		boolean done1=false;
		boolean done2=false;
		
		int val1=0;
		int val2=0;
		while(true)
		{
			// Find next node in normal Inorder traversal.
			while(done1==false)
			{
				if(curr1!=null)
				{
					s1.push(curr1);
					curr1=curr1.left;
				}
				else
				{
					curr1=s1.pop();
					val1=curr1.data;
					curr1=curr1.right;
					done1=true;
				}
			}
		
			// Find next node in REVERSE Inorder traversal.
			while(done2==false)
			{
				if(curr2!=null)
				{
					s2.push(curr2);
					curr2=curr2.right;
				}
				else
				{
					curr2=s2.pop();
					val2=curr2.data;
					curr2=curr2.left;
					done2=true;
				}
			}
			
			if(val1!=val2 && val1+val2==target)
			{
				System.out.println("PAIR FOUND "+val1+" and "+val2);
				return true;
			}
			else if(val1+val2<target)
				done1=false;
			else if(val1+val2>target)
				done2=false;
			
			if(val1>val2)
				return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root =  new TreeNode(15);
	    root.left = new TreeNode(10);
	    root.right = new TreeNode(20);
	    root.left.left = new TreeNode(8);
	    root.left.right = new TreeNode(12);
	    root.right.left = new TreeNode(16);
	    root.right.right = new TreeNode(25);
	 
	    int target = 33;
	    if (isPairPresent(root, target) == false)
	        System.out.println("\n No such values are found\n");
	    

	}

}
