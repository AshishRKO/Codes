
public class DeleteNth 
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

	public static Node delete(Node head,int n)
	{
		Node start = new Node(0);
        Node slow = start, fast = start;
        slow.next = head;
        
        for(int i=1;i<=n+1;i++)
        {
            fast=fast.next;
        }
        
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        slow.next=slow.next.next;
        
        return start.next;

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

		delete(A,2); // Node is returned in the function but not taken

		print(A); // Node is still changed

	}

}
