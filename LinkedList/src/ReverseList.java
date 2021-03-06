/* Reverse a Linked List both recursively and iteratively

/* Uncomment this if you are using this outside the package where Node.java is not available
/*
class Node
{
	int data;
	Node next;
	public Node()
	{
		this.next=null;
	}
	
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}*/

public class ReverseList 
{
	// Function to print the List
	public static void print(Node start)
	{
	    Node temp=start;
	    while(temp!=null)
	    {
	        System.out.print(temp.data+" ");
	        temp=temp.next;
	    }
	    System.out.println();
	}

	// Head of Reversed list will be stored in this variable
	public static Node head;
	// Function to reverse a Linked List recursively
	public static Node reverseRecursively(Node start)
	{
		if(start==null)
			return null;

		helper(start);
		return head;
	}

	// Helper function for reversing the list
	public static void helper(Node start)
	{
		if(start.next==null)
		{
			// This is the Last node of the list
			// Make head point to last node of the list
			head=start;
			return ;
		}

		// Recursively calling helper to reach last node
		helper(start.next);

		// For the first time q is the last Node and start is second last Node
		Node q=start.next;
		// Make last Node point to second last 
		q.next=start;
		// Make second last node null
		start.next=null;
	}

	// Function to reverse List iteratively
	public static Node reverse(Node start)
	{
		if(start==null)
			return null;

		// curr - To store the current Node
		Node curr=start;
		// prev - To store the previous Node
		Node prev=null;
		// NEXT - To store the next variabe in the node
		Node NEXT;

		while(curr!=null)
		{
			// Storing the next Node
			NEXT=curr.next;
			// Changing the link of a node to point to its previous node
			curr.next=prev;
			// Making previous node the current node 
			prev=curr;
			// Current is now moving forward
			curr=NEXT;
		}
		// prev is the last Node. Make the start point to prev
		start=prev;

		return start;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Node A=new Node(1);
		A.next=new Node(2);
		A.next.next=new Node(3);
		A.next.next.next=new Node(4);
		A.next.next.next.next=new Node(5);
		A.next.next.next.next.next=new Node(6);
		
		print(A);

		//print(reverseRecursively(A));

		print(reverse(A));

		// Address of A is changed
		print(A);
	}

}
