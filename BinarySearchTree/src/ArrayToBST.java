
public class ArrayToBST 
{
	public TreeNode sortedArrayToBST(int[] a) 
    {
        if(a.length==0)
            return null;
            
        if(a.length==1)
            return new TreeNode(a[0]);
            
        TreeNode root=helper(a,0,a.length-1);
        return root;
    }
    
    public TreeNode helper(int a[],int start,int end)
    {
        if(start>end)
            return null;
            
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(a[mid]);
        
        root.left=helper(a,start,mid-1);
        root.right=helper(a,mid+1,end);
        
        return root;
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
