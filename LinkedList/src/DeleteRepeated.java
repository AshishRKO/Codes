/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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

public class DeleteRepeated 
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

	public static Node delete(Node start)
	{
		if(start==null)
			return null;

		Node FakeHead=new Node(0);
		Node prev=FakeHead;
		Node curr=start;
		Node next;
		while(curr!=null)
		{
			next=curr.next;
			//System.out.println("next= "+next.data);
			//System.out.println("curr= "+curr.data);
			if(next!=null && curr.data==next.data)
			{
				while(next!=null && curr.data==next.data)
				{
					System.out.println("inside next= "+next.data);
					System.out.println("inside curr= "+curr.data);
					curr=next;
					next=curr.next;
				}
				
				System.out.println("OK");
				//System.out.println("prev= "+prev);
				if(prev==null)
				{
					start=start.next;
				}
				else if(prev.next==curr)
					prev=prev.next;
				else
				{
					System.out.println("prev= "+prev.data);
					System.out.println("next= "+next);
					prev.next=next;
				}
			}
			curr=curr.next;
		}
		return start;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Node A=new Node(2);
		A.next=new Node(2);
		A.next.next=new Node(2);
		A.next.next.next=new Node(2);
		A.next.next.next.next=new Node(5);
		A.next.next.next.next.next=new Node(5);
		
		print(A);

		print(delete(A));


	}

}
