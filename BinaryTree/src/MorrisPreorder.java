
public class MorrisPreorder 
{
	public static void preorder(TreeNode root)
	{
		if(root==null)
			return ;
		
		TreeNode curr=root;
		while(curr!=null)
		{
			// If left node is null print the node and go to right
			if(curr.left==null)
			{
				System.out.print(curr.data+" ");
				curr=curr.right;
			}
			else
			{
				// Find Inorder predecessor
				TreeNode pred=curr.left;
				while(pred.right!=curr && pred.right!=null)
				{
					pred=pred.right;
				}
				
				if(pred.right==null)
				{
					// Make a link from predecessor to current
					pred.right=curr;
					System.out.print(curr.data+" ");
					curr=curr.left;
				}
				else if(pred.right==curr)
				{
					// left subtree is already visited. Go to right
					
					pred.right=null;
					curr=curr.right;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		
		preorder(root);


	}

}
