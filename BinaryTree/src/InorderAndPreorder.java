
public class InorderAndPreorder 
{
	//static TreeNode root;
	static int i=0;
	public static TreeNode buildTree(int in[], int pre[], int instart, int inend)
	{
		if(instart>inend)
		{
			return null;
		}
		//System.out.println("pre[i++]= "+pre[i++]);
		TreeNode root=new TreeNode(pre[i]);
		i++;
		
		int Inindex=search(in,instart, inend, root.data);
		root.left=buildTree(in,pre,instart,Inindex-1);
		root.right=buildTree(in,pre,Inindex+1,inend);

		return root;
	}

	public static int search(int arr[], int strt, int end, int value) 
	{
        int i;
        for (i = strt; i <= end; i++)
        {
            if (arr[i] == value) 
            {
                return i;
            }
 
        }
        return i;
    }

	public static void inorder(TreeNode root)
	{
		if(root==null)
		{
			return ;
		}

		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// int in[]={4,2,5,1,6,3};
		// int pre[]={1,2,4,5,3,6};

		int in[]={2,1};
		int pre[]={1,2};

		TreeNode root=buildTree(in, pre, 0, in.length-1);
		inorder(root);

	}

}
