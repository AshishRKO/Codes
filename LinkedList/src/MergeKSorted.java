
public class MergeKSorted 
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

	public static Node merge(Node A, Node B)
	{
		if(A==null)
			return null;
		if(B==null)
			return null;
		Node temp1=A;
		Node temp2=B;
		Node dummy=new Node(0);
		Node res=dummy;
		while(temp1!=null && temp2!=null)
		{
			if(temp1.data<=temp2.data)
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
		return null;
	}
	

	public static Node mergeK(Node lists[])
	{
		return partition(lists,0,lists.length-1);
	}


	public static Node partition(Node lists[],int s,int e)
	{
		if(s==e)
			return lists[s];
		if(s<e)
		{
			int q=(s+e)/2;
			Node first=partition(lists,s,q);
			Node second=partition(lists,q+1,e);

			Node res=merge(first,second);
			return res;
		}
		else
			return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
