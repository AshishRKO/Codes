
public class InsertionSort 
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


	public static Node sort(Node start)
	{
		if(start==null)
			return null;

		// fakeHead - It is used so that prev node is not null 
		Node fakeHead=new Node(0);
		Node prev=fakeHead;
		Node curr=start;

		while(curr!=null)
		{
			// At each iteration we have look from the start for the position of curr
			prev=fakeHead;
			while(prev.next!=null && prev.next.data<curr.data)
			{
				// keep moving till you find the position for start
				prev=prev.next;
			}

			// Once you find the position for inserting curr
			// Insert curr between prev and prev.next
			Node next=curr.next;
			curr.next=prev.next;
			prev.next=curr;
			curr=next;
		}

		return fakeHead.next;

	} 

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Node A=new Node(100);
		A.next=new Node(2);
		A.next.next=new Node(33);
		A.next.next.next=new Node(4);
		A.next.next.next.next=new Node(15);
		A.next.next.next.next.next=new Node(6);
		
		System.out.println("Original Linked List");
		print(A);

		System.out.println("After InsertionSort");
		print(sort(A));

	}

}
