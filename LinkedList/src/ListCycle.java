/* Given a linked list, determine if it has a cycle in it */

public class ListCycle 
{
	// Function to detect the cycle in a Linked List
	public static boolean hasCycle(Node start)
	{
		if(start==null || start.next==null)
			return false;
		
		Node slow=start;
		Node fast=start;
		// if slow and past pointer ever meet then list has a cycle
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{
				return true;
			}
		}
		return false;
	}
	
	
	// Function to count the length of the cycle
	public static int countCycleLength(Node start)
	{
		int count=0;
		boolean flag=false;
		if(start==null || start.next==null)
			return 0;
		
		Node slow=start,fast=start;
		
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{
				if(count==0)
					flag=true;
				else
					return count;
			}
			
			// Flag=true means that there is a cycle in the List
			if(flag==true)
				count++;
			
		}
		return count;
	}
	
	
	
	public static void main(String[] args) 
	{
		//Node A - The List with loop
		Node A=new Node(1);
		A.next=new Node(2);
		A.next.next=new Node(3);
		A.next.next.next=new Node(4);
		A.next.next.next.next=new Node(5);
		A.next.next.next.next.next=new Node(6);
		A.next.next.next.next.next.next=A.next.next;
		
		if(hasCycle(A)==true)
			System.out.println("Linked List has cycle");
		else
			System.out.println("Linked List does not have any cycle");
		
		
		System.out.println("Length of Cycle= "+countCycleLength(A));
		
	}
}
