import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal 
{
	// Level order traversal in one line
	public static void levelOrder(TreeNode root)
	{
		if(root==null)
			return ;
		// Using queue
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			root = q.poll();
			System.out.print(root.data+" ");
			if(root.left!=null)
			{
				q.add(root.left);
			}
			
			if(root.right!=null)
			{
				q.add(root.right);
			}
			
		}
	}
	
	public static void levelbylevel(TreeNode root)
	{
		if(root==null)
		{
			return ;
		}
		
		Queue<TreeNode> q1=new LinkedList<TreeNode>();
		Queue<TreeNode> q2=new LinkedList<TreeNode>();
		
		q1.add(root);
		
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			while(!q1.isEmpty())
			{
				root=q1.poll();
				System.out.print(root.data+" ");
				if(root.left!=null)
				{
					q2.add(root.left);
				}
				if(root.right!=null)
				{
					q2.add(root.right);
				}
			}
			
			System.out.println();
			
			while(!q2.isEmpty())
			{
				root=q2.poll();
				System.out.print(root.data+" ");
				if(root.left!=null)
				{
					q1.add(root.left);
				}
				if(root.right!=null)
				{
					q1.add(root.right);
				}
			}
			System.out.println();
		}
	}
	
	
	public static void reverseLevel(TreeNode root)
	{
		if(root==null)
			return ;
		
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		Stack<TreeNode> s=new Stack<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			root=q.poll();
			
			if(root.right!=null)
			{
				q.add(root.right);
			}
			if(root.left!=null)
			{
				q.add(root.left);
			}
			s.push(root);
			System.out.print(root.data+" ");
		}
		
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.right=new TreeNode(5);

		levelOrder(root);
		System.out.println("\nLEVEL BY LEVEL");
		levelbylevel(root);
		
		reverseLevel(root);
		// Time complexity- O(n)
		// Space Compeity- O(n)

	}

}
