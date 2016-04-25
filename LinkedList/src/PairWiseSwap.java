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
}
*/
public class PairWiseSwap 
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
	

	public static Node Swap(Node start)
	{
		if(start==null)
			return null;

		Node temp=start;
		while(temp!=null && temp.next!=null)
		{
			int t=temp.data;
			temp.data=temp.next.data;
			temp.next.data=t;
			temp=temp.next.next;
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
		A.next.next.next.next.next=new Node(6);
		A.next.next.next.next.next.next=new Node(7);
		print(A);

		Swap(A);// Node is returned in the function but not taken
		
		// Node is still changed
		print(A);
	}

}
