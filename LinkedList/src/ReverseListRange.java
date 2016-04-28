/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
*/

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

public class ReverseListRange 
{

	// Function to print a Linked List
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


	public static Node reverse(Node start, int m, int n)
	{
		// If the List is Empty
		if(start==null)
			return null;
			
		// If there is no range, There is no need to change the List
		if(m==n)
		    return start;

		Node curr=start;
		// NEXT - For storing next Node of current
		Node NEXT=curr.next,prev=null;
		
		int i;
		for(i=0;i<m-1;i++)
		{
			prev=curr;
			curr=curr.next;
		}

		// starting - For storing the node just before starting of the reversed List 
		Node starting=prev;
		// ending - For storing the starting node of reversing list that will be the last node after reversing the list.
		Node ending=curr;
		// prev - Previous Node
		prev=curr;

		// Making current the second node of the list
		// EX- For m=2 and n=4 and  1->2->3->4->5->6 then prev=2, curr=3, NEXT=4 
		curr=curr.next;
		
		for(i=0;i<n-m;i++)
		{
			// Storing the next node of curr
			NEXT=curr.next;
			// reverse the pointer of curr to previous node
			curr.next=prev;
			// making previous current
			prev=curr;
			// making current the next node
			curr=NEXT;
		}
		
		if(starting!=null)
		{
			// Starting should be last node now and prev should be first node of the reversed List
		    starting.next=prev;
		}
		else
		{
			// For Case when starting element of list is also reversed
			start=prev;
		}
		
		// Joining end of the reversed list to rest of the reversed list
		ending.next=NEXT;

		return start;
	}


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Node A=new Node(1);
		A.next=new Node(2);
		A.next.next=new Node(3);
		//A.next.next.next=new Node(4);
		//A.next.next.next.next=new Node(5);
		//A.next.next.next.next.next=new Node(1);
		
		print(A);

		print(reverse(A, 1, 3));

	}

}
