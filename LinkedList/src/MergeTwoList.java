// Merge two sorted linked lists

/* Uncomment this if you are using this outside the package where Node.java is not available
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
public class MergeTwoList
{
	public static void print(Node start)
	{
	    Node temp=start;
	    while(temp!=null)
	    {
	        System.out.print(temp.value+" ");
	        temp=temp.next;
	    }
	}
	
	public static void merge(Node A, Node B)
	{
		if(A==null)
			return ;
		if(B==null)
			return ;
		Node temp1=A;
		Node temp2=B;
		Node dummy=new Node(0);
		Node res=dummy;
		while(temp1!=null && temp2!=null)
		{
			if(temp1.value<=temp2.value)
			{
				res.next=temp1;
				temp1=temp1.next;
			}
			else
			{
				res.next=temp2;	
				temp2=temp2.next;
			}
			res=res.next;
		}
	
		if(temp1!=null)
		{
			res.next=temp1;
		}
		if(temp2!=null)
		{
			res.next=temp2;
		}
		System.out.println("NOTHING");
		print(dummy.next);
	}
	
	public static void main(String args[])
	{
		Node A=new Node(1);
		A.next=new Node(2);
		A.next.next=new Node(4);
		A.next.next.next=new Node(8);
		A.next.next.next.next=new Node(12);
		A.next.next.next.next.next=new Node(20);
		//print(A);
		Node B=new Node(0);
		B.next=new Node(3);
		B.next.next=new Node(5);
		B.next.next.next=new Node(7);
		B.next.next.next.next=new Node(11);
		B.next.next.next.next.next=new Node(25);
		//print(B);
		merge(A,B);
		//print(mergeTwoLists(A,B));
	}
}
