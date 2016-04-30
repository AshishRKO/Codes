/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
1,2,3,4,5       1,5,2,4,3
1 2 5 4 3       1 5 2 4 
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


public class ReorderList 
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



	public static Node reorder(Node head)
	{
		if(head==null||head.next==null) 
			return null;

            //Find the middle of the list
            Node p1=head;
            Node p2=head;
            while(p2.next!=null && p2.next.next!=null)
            { 
                p1=p1.next;
                p2=p2.next.next;
            }
            Node mid=p1;
            Node nullable=p1.next;
            //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
            
            //System.exit(0);
            
            Node prev=p1.next;
            Node curr=prev.next;
            Node NEXT;
            while(curr!=null)
            {
            	NEXT=curr.next;
            	curr.next=prev;
            	prev=curr;
            	curr=NEXT;
            }

            mid.next=prev;
            nullable.next=null;

    		print(head);
    		System.out.println("P1.data= "+p1.data);
    		System.out.println("mid.data= "+mid.data);
    		Node temp=head;
    		Node tempNEXT;
    		Node midNext;
    		mid=mid.next;
    		while(temp!=mid)
    		{
    			tempNEXT=temp.next;
    			temp.next=mid;
    			midNext=mid.next;
    			mid.next=tempNEXT;
    			temp=tempNEXT;
    			mid=midNext;
    		}

    		/*
    		p1=head;
    		p2=mid.next;
    		while(p1!=mid)
    		{
    			mid.next=p2.next;
    			p2.next=p1.next;
    			p1.next=p2;
    			p1=p2.next;
    			p2=mid.next;
    		}
			*/

            return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node A=new Node(1);
		A.next=new Node(2);
		A.next.next=new Node(3);
		A.next.next.next=new Node(4);
		A.next.next.next.next=new Node(5);
		A.next.next.next.next.next=new Node(6);
		
		print(A);

		print(reorder(A));

	}


}
