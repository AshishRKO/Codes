/* Problem- Sort the Linked List with datas 0,1,2 */

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

public class SORT012 
{
	public static void print(Node start)
	{
	    Node temp=start;
	    while(temp!=null)
	    {
	        System.out.print(temp.data+" ");
	        temp=temp.next;
	    }
	}

	public static void linksort(Node start)
	{
	//Add code here
	Node res=new Node(0);
			res.next=start;
		    int zero,one,two;
		    zero=0;
		    one=0;
		    two=0;
		    Node temp=start;
		    
		    
		    while(temp!=null)
		    {
		        if(temp.data==0)
		        {
		            zero++;
		        }
		        else if(temp.data==1)
		        {
		            one++;
		        }
		        else if(temp.data==2)
		        {
		            two++;
		        }
		        temp=temp.next;
		    }
		    
		    temp=start;
		    while(temp!=null)
		    {
		        if(zero!=0)
		        {
		            temp.data=0;
		            zero--;
		        }
		        else if(one!=0)
		        {
		            temp.data=1;
		            one--;
		        }
		        else if(two!=0)
		        {
		            temp.data=2;
		            two--;
		        }
		        temp=temp.next;
		    }
		    print(res.next);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node A=new Node(1);
		A.next=new Node(2);
		A.next.next=new Node(2);
		A.next.next.next=new Node(1);
		A.next.next.next.next=new Node(2);
		A.next.next.next.next.next=new Node(0);
		A.next.next.next.next.next.next=new Node(2);
		A.next.next.next.next.next.next.next=new Node(2);
		linksort(A);
		

	}

}
