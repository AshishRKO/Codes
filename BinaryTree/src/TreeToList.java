
public class TreeToList 
{
	static TreeNode prev=null;
    public static void flatten(TreeNode root) 
    {
        if(root==null)
            return ;
        
        
        flatten(root.right);
        flatten(root.left);
        // Since we are creating list from bottom to up
        root.right=prev;
        root.left=null;
        prev=root;
            
    }
    
    public static void inorder(TreeNode root)
    {
    	if(root==null)
    		return ;
    	
    	inorder(root.left);
    	System.out.print(root.data+" ");
    	inorder(root.right);
    }
    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TreeNode root =  new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
					    /*
				        15
				     /     \
				   10      20
				  / \     /  \
				 8  12   16  25    */
	    
	    flatten(root);
	    inorder(root);
	}

}