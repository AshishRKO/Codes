//Convert Sorted List to Binary Search Tree
/*
Input:  Linked List 1->2->3->4->5->6
Output: A Balanced BST
      4   
    /   \  
   2     6 
 /  \   / 
1   3  5    
*/ 
/*
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
class ListNode
{
	int data;
	ListNode next;
	
	public ListNode(int data)
	{
		this.data=data;
	}
}

public class SortedListToTree 
{
    static ListNode cur;
    public static TreeNode sortedListToBST(ListNode start) 
    {
        cur=start;
        int n=count(start);
		return helper(n);   
    }
    
    public static int count(ListNode start)
	{
		if(start==null)
			return 0;
		int c=0;
		ListNode temp=start;
		while(temp!=null)
		{
			temp=temp.next;
			c++;
		}
		return c;	
	}
	
	public static TreeNode helper(int n)
	{
		if(n==0)
			return null;
		TreeNode root=new TreeNode(0);
		/* Recursively construct the left subtree */
		root.left=helper(n/2);
				
		root.data=cur.data;
		/* Change head pointer of Linked List for parent recursive calls */
		cur=cur.next;
		
		/* Recursively construct the right subtree and link it with root 
	      The number of nodes in right subtree  is total nodes - nodes in 
	      left subtree - 1 (for root) which is n-n/2-1*/
		root.right=helper(n-n/2-1);
		return root;
	}
	public static void inorder(TreeNode root)
	{
		if(root==null)
		{
			return ;
		}

		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A=new ListNode(1);
		A.next=new ListNode(2);
		A.next.next=new ListNode(3);
		A.next.next.next=new ListNode(4);
		A.next.next.next.next=new ListNode(5);
		A.next.next.next.next.next=new ListNode(6);
		
		TreeNode root= sortedListToBST(A);
		inorder(root);

	}

}
