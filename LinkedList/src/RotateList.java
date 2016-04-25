/* Rotate a list both LEFT and RIGHT */
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

public class RotateList 
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
	
	
	public static Node rotate(Node start,int k)
	{
		if(start==null)
			return null;
		Node temp=start;
		Node starting=start;
		Node res;
		
		int i;
		for(i=1;i<k;i++)
		{
			temp=temp.next;
		}
		res=temp.next;
		temp.next=null;
		
		Node temp2=res;
		while(temp2.next!=null)
		{
			temp2=temp2.next;
		}
		temp2.next=starting;
		return res;
	}
	
	public static Node ROTATE_LEFT(Node start,int k)
	{
		if(start==null)
			return null;
		
		Node tail=start;
		int len=1;
		while(tail.next!=null)
		{
			tail=tail.next;
			len++;
		}
		tail.next=start;
		
		k=k%len;
		
		int i;
		for(i=0;i<k;i++)
		{
			tail=tail.next;
		}
		
		start=tail.next;
		tail.next=null;
		
		
		return start;
	}
	
	public static Node ROTATE_RIGHT(Node start,int k)
	{
		//Function To Rotate the List in right direction
		
		//variable to find the end of the list
		Node tail=start;
		
		//len = Variable to find length of the list
		int len=1;
		
		while(tail.next!=null)
		{
			tail=tail.next;
			len++;
		}
		//Make the list circular
		tail.next=start;
		
		//k might be more than length of the list
		k=k%len;
		
		int i;
		//Reach the breaking point of list 
		for(i=0;i<len-k;i++)
		{
			tail=tail.next;
		}
		
		//Make the start point to the new start
		start=tail.next;
		tail.next=null;

		return start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node A=new Node(1);
		A.next=new Node(2);
		A.next.next=new Node(3);
		A.next.next.next=new Node(4);
		A.next.next.next.next=new Node(5);
		A.next.next.next.next.next=new Node(6);
		
		System.out.println("ORIGINAL LIST");
		print(A);
		
		System.out.println("LEFT ROTATION");
		print(ROTATE_LEFT(A,4));

		
		Node B=new Node(10);
		B.next=new Node(20);
		B.next.next=new Node(30);
		B.next.next.next=new Node(40);
		B.next.next.next.next=new Node(50);
		B.next.next.next.next.next=new Node(60);
		
		System.out.println("ORIGINAL LIST");
		print(B);
		
		System.out.println("RIGHT ROTATION");
		print(ROTATE_RIGHT(B,4));
		

	}

}
