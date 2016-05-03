import java.util.HashMap;

class RandomListNode
{
    int data;//Node data
    RandomListNode next;
	RandomListNode random;//Next and random reference
 
    //Node constructor
    public RandomListNode(int data)
    {
        this.data = data;
        this.next = this.random = null;
    }
}

public class CloneList 
{
	// with extra space
    public static RandomListNode clone(RandomListNode start)
    {
    	if(start==null)
            return null;

        RandomListNode curr=start;
        RandomListNode copy=null;

        HashMap<RandomListNode, RandomListNode> h=new HashMap<RandomListNode, RandomListNode>();
        while(curr!=null)
        {
        	// Making Nodes for clone of the Random List
            copy=new RandomListNode(curr.data);
            // Putting current and clone list in the HashMap
            h.put(curr, copy);
            curr=curr.next;
        }

        curr=start;

        // Original and clone list are put together in Hashmap
        while(curr!=null)
        {
        	// get the startting node of clone list
            copy=h.get(curr);
            // get the next of clone list
            copy.next=h.get(curr.next);
            // get the random of clone list
            copy.random=h.get(curr.random);
            curr=curr.next;
        }

        RandomListNode res=h.get(start);
        return res;
    }

    // Without extra space
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.data);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
	public static void main(String[] args) 
    {
		// TODO Auto-generated method stub

	}

}
