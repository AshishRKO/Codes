/* Intersection of Two Linked Lists */
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

public class IntersectingList 
{
	public static void print(Node start)
	{
	    Node temp=start;
	    while(temp!=null)
	    {
	        System.out.print(temp.value+" ");
	        temp=temp.next;
	    }
	    System.out.println();

	}

    public static Node getIntersectionNode(Node A, Node B) 
    {
            if(A==null || B==null)
                return null;
                
            Node temp1=A;
            Node temp2=B;
             
            
            while(temp1!=temp2)
            {
            	//Both list will meet at the intersection point
            	
            	// Check if the first list has reached the end. Then point it to the second list
                if(temp1==null)
                    temp1=B;
                else
                    temp1=temp1.next;
                
                // Check if the second list has reached the end. Then point it to the first list
                if(temp2==null)
                    temp2=A;
                else
                    temp2=temp2.next;
            }
            return temp1;
    }
    
	public static void main(String[] args)
	{
		// A and B are two Linked List that intersects 
		Node A=new Node(1);
		A.next=new Node(2);
		A.next.next=new Node(3);
		A.next.next.next=new Node(4);
		A.next.next.next.next=new Node(5);
		A.next.next.next.next.next=new Node(6);
		print(A);
		
		Node B=new Node(10);
		B.next=new Node(20);
		B.next.next=new Node(30);
		B.next.next.next=A.next.next;
		print(B);
		
		Node res= getIntersectionNode(A, B);
		if(res!=null)
		{
			System.out.println("INTERSECTION POINT = "+res.value);
		}
		else
			System.out.println("List do not intesect each other");
	}

}
