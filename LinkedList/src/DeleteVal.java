/*
Delete all occurance of a value in the Linked Lis\
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

public class DeleteVal 
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


	public static Node delete(Node start, int val)
	{
		if(start==null)
			return null;

		// curr - Current Node of the list
		Node curr=start;
		// prev - Previous Node of the list
		Node prev=null;

		while(curr!=null)
		{
			// If found the val
			if(curr.data==val)
			{
				// If it is the first element
				if(prev==null)
				{
					// delete the first element
					start=start.next;
				}
				else
				{
					prev.next=curr.next;
					// or prev.next=curr.next.next;
				}
			}
			else
			{
				prev=curr;
			}

			curr=curr.next;

		}
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
		A.next.next.next.next.next=new Node(1);
		
		print(A);

		print(delete(A,1));

	}

}
