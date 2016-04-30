
public class MergeSort 
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

	// Function for merging two sorted Linked List
	public static Node mergeTwoLists(Node l1, Node l2)
    {
        if(l1==null && l2==null)
            return null;
            
        if(l1==null)
            return l2;
            
        if(l2==null)
            return l1;
            
        Node temp1=l1;
        Node temp2=l2;
        
        Node dummy=new Node(0);
        Node res=dummy;
        
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data<temp2.data)
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
        else
        {
            res.next=temp2;
        }
            
        return dummy.next;
    }
	
	public static Node mergeSort(Node start)
	{
		if(start==null || start.next==null)
			return start;

		Node slow=start;
		Node fast=start;
		Node prev=null;

		// Getting to the middle of the Linked List
		while(fast!=null && fast.next!=null)
		{
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		
		// Dividing the list into two parts
		prev.next=null;

		Node first=mergeSort(start);
		Node second=mergeSort(slow);

		// merging the two linked list
		Node res=mergeTwoLists(first,second);
		return res;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Node A=new Node(46);
		A.next=new Node(2);
		A.next.next=new Node(3);
		A.next.next.next=new Node(1);
		A.next.next.next.next=new Node(56);
		A.next.next.next.next.next=new Node(5);
		System.out.println("Original List");
		print(A);
		System.out.println("After Merge Sort");
		print(mergeSort(A));

	}

}




