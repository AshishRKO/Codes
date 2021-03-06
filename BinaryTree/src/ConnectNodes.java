/*
 * Connect nodes at same level using constant extra space
 */
class TreeLinkNode 
{
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) 
      { 
    	  val = x;
      }
}

public class ConnectNodes 
{
	public void connect(TreeLinkNode root) 
    {
        TreeLinkNode curr=root;
        // head - For iterations in levels
        TreeLinkNode head=null;
        TreeLinkNode prev=null;
        
        while(curr!=null)
        {
            //iterate on the current level
            while(curr!=null)
            {
                //left child
                if(curr.left!=null)
                {
                    if(prev!=null)
                        prev.next=curr.left;
                    else
                        head=curr.left;
                        
                    prev=curr.left;
                }
                
                //right child
                if(curr.right!=null)
                {
                    if(prev!=null)
                        prev.next=curr.right;
                    else
                        head=curr.right;
                        
                    prev=curr.right;
                }
                
                //move to next node
                curr=curr.next;
            }
            // Iterating curr through the use of head
            curr=head;
            // the starting conditions
            head=null;
            prev=null;
        }    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
