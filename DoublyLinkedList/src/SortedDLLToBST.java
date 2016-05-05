class ListNode
{
	int data;
	ListNode prev;
	ListNode next;
	
	public ListNode(int data)
	{
		this.data=data;
	}
}


public class SortedDLLToBST 
{
	public static int getLength(ListNode start)
	{
		ListNode temp=start;
		int c=0;
		while(temp!=null)
		{
			c++;
			temp=temp.next;
		}
		return c;
	}
	static ListNode curr;
	public static ListNode DLLToBST(ListNode start)
	{
		int n=getLength(start);
		curr=start;
		return helper(n);
	}
	
	public static ListNode helper(int n)
	{
		if(n==0)
			return null;
		// /* Recursively construct the left subtree */
		ListNode left = helper(n/2);
		 /* curr now refers to middle node of subtree, make middle node as root of BST*/
		ListNode root=curr;
		// Set pointer to left subtree
		root.prev=left;
		
		/* Change head pointer of Linked List for parent recursive calls like inorder*/
		curr=curr.next;
		/* Recursively construct the right subtree and link it with root
	      The number of nodes in right subtree  is total nodes - nodes in
	      left subtree - 1 (for root) */
		root.next = helper(n-n/2-1);
		return root;
		
	}
	
	public static void inorder(ListNode root)
	{
		if(root==null)
		{
			return ;
		}
		
		inorder(root.prev);
		System.out.print(root.data+" ");
		inorder(root.next);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A=new ListNode(1);
		A.next=new ListNode(2);
		A.next.next=new ListNode(3);
		A.next.next.next=new ListNode(4);
		A.next.next.next.next=new ListNode(5);
		A.next.next.next.next.next=new ListNode(6);
		
		ListNode root = DLLToBST(A);
		inorder(root);
		
	

	}

}
