/*
In a linked list, group all even nodes together followed by the odd nodes. Please note here we are talking about the node number and not the value in the nodes.

Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
*/
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



public class OddEven 
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
	
	public static Node OddEvenList(Node start)
	{
		if(start==null)
			return null;

		Node temp=start;
		Node res=new Node(0);
		// For odd list
		Node odd=res;

		Node result=new Node(-1);
		// For even list
		Node even=result;

		int i=0;
		while(temp!=null)
		{
			if(i%2==0)
			{
				// Pointing to Odd positioned Element
				odd.next=temp;
				odd=odd.next;
			}
			else
			{
				// Pointing to even positioned Element
			 	even.next=temp;
			 	even=even.next;
			}

			temp=temp.next;
			i++;
		}

		// Making sure that last node of even positioned List is null
		even.next=null;

		// Join Odd and Even Lists
		odd.next=result.next;
		return res.next;

	}

	// Another much BETTER solution
	public static Node OddEvenList2(Node start)
	{
		if(start==null)
			return null;
		// For odd node
		Node odd=start;
		// For even node
		Node even=start.next;
		// For the result
		Node evenhead=even;

		while(odd.next!=null && even.next!=null)
		{
			// Next odd node will be next of even node 
			odd.next=even.next;
			odd=odd.next;

			// Next even node will be next of odd node
			even.next=odd.next;
			even=even.next;
		}

		// Pointing next of odd list to begining of even list to JOIN them
		odd.next=evenhead;

		// return the head pointer
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
		//A.next.next.next.next.next=new Node(6);
		
		print(A);

		print(OddEvenList(A));
		print(OddEvenList2(A));
	}

}
