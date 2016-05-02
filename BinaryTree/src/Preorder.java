import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder 
{
	public static List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> s=new Stack<TreeNode>();
        if(root==null)
            return res;
        s.push(root);
        
        while(!s.isEmpty())
        {
            root=s.pop();
            res.add(root.data);
            if(root.right!=null)
                s.push(root.right);
            if(root.left!=null)
                s.push(root.left);
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.right=new TreeNode(5);

		System.out.println("Height = "+preorderTraversal(root));

	}

}
