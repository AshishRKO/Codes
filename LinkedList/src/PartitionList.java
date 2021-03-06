/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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


public class PartitionList 
{

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

	
	public static Node Partition(Node start, int x)
	{
		if(start==null)
			return null;

		// These nodes are for making list whose value is less than x 
		Node dummy=new Node(0);	
		Node temp=dummy;
		// These nodes are for making list whose value is greater than x
		Node dummy2=new Node(-1);
		Node temp2=dummy2;

		Node curr=start;
		while(curr!=null)
		{
			// Less than x
			if(curr.data<x)
			{
				temp.next=curr;
				temp=temp.next;
			}
			// Greater than x
			else
			{
			 	temp2.next=curr;
			 	temp2=temp2.next;
			}
			curr=curr.next;
		}
		// Joining the Two lists
		temp.next=dummy2.next;
		// Second list's next must end right here. Otherwise it will pick up rest of the values in the list alread picked up b first list
		temp2.next=null;
		
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node A=new Node(1);
		A.next=new Node(4);
		A.next.next=new Node(3);
		A.next.next.next=new Node(2);
		A.next.next.next.next=new Node(5);
		A.next.next.next.next.next=new Node(2);
		A.next.next.next.next.next.next=new Node(15);
		A.next.next.next.next.next.next.next=new Node(20);
		
		System.out.println("Original Linked List");
		print(A);

		System.out.println("After InsertionSort");
		print(Partition(A,3));

	}

}
