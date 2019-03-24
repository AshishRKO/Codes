import java.util.LinkedList;
import java.util.Queue;

public class HeightORMaxDepth
{


static int max = -1;
	static int levelOrder(TreeNode root) {
		if (root == null)
			return 0;


		if(root.left == null && root.right == null)
			return 1;


		int left = levelOrder(root.left);

		int right = levelOrder(root.right);


		if(left == right)
			root.data = 2*left;
		else if(left > right)
			root.data = left;
		else if(right > left)
			root.data = right;


		if(max<root.data)
			max = root.data;

		return root.data;


	}


	public static void doo(TreeNode root)
	{
		if(root == null)
			return ;
		if(root.left == null && root.right == null)
			return;
		levelOrder(root);

		//System.out.println(max);
		int ans = 2*max-1;
		System.out.println(ans);
	}


	public static void test1()
	{
		System.out.print("Test1: ");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		root.right.right.left = new TreeNode(9);
		root.right.right.right = new TreeNode(10);

		root.right.right.right.left = new TreeNode(11);
		root.right.right.right.right = new TreeNode(6);

		root.right.right.right.right.right = new TreeNode(6);
		doo(root);

		System.out.println(max == 4);
	}


	public static void test2()
	{
		System.out.print("Test2: ");
		max = -1;
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		//root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		//root.right.left.left = new TreeNode(7);
		//root.right.left.right = new TreeNode(8);

		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(8);


		doo(root);

		System.out.println(max == 4);
	}


	public static void test3()
	{
		System.out.print("Test3: ");
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);

		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);

		root.right.right.left = new TreeNode(12);
		root.right.right.right = new TreeNode(13);

		root.right.right.left.left = new TreeNode(14);
		root.right.right.left.right = new TreeNode(15);

		root.right.right.right.left = new TreeNode(16);
		root.right.right.right.right = new TreeNode(17);


		doo(root);

		System.out.println(max == 8);
	}


	public static void test4()
	{
		System.out.print("Test4: ");
		TreeNode root = new TreeNode(1);
		//root.left = new TreeNode(2);
		root.right = new TreeNode(2);

		//root.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(3);
		root.right.left.left = new TreeNode(5);

		root.right.left.left.right = new TreeNode(6);

		root.right.left.left.right.left = new TreeNode(7);

		root.right.left.left.right.left.right = new TreeNode(8);

		root.right.left.left.right.left.right.left = new TreeNode(9);
		root.right.left.left.right.left.right.right = new TreeNode(10);

		root.right.left.left.right.left.right.left.left = new TreeNode(11);
		root.right.left.left.right.left.right.left.right = new TreeNode(12);

		root.right.left.left.right.left.right.right.left = new TreeNode(13);
		root.right.left.left.right.left.right.right.right = new TreeNode(14);


		root.right.right = new TreeNode(4);

		root.right.right.left = new TreeNode(15);
		root.right.right.right = new TreeNode(16);

		root.right.right.left.left = new TreeNode(17);
		root.right.right.left.right = new TreeNode(18);

		root.right.right.right.left = new TreeNode(19);
		root.right.right.right.right = new TreeNode(20);

		doo(root);

		System.out.println(max == 8);
	}


	public static void test5()
	{
		System.out.print("Test5: ");
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(11);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);


		root.left.left.left = new TreeNode(5);
		root.left.left.left.left = new TreeNode(6);

		root.left.left.left.left.left = new TreeNode(7);
		root.left.left.left.left.right = new TreeNode(8);
		//root.left.left.right = new TreeNode(9);

		root.left.right.left = new TreeNode(9);
		root.left.right.right = new TreeNode(10);




		root.right.left = new TreeNode(12);
		root.right.left.left = new TreeNode(13);
		root.right.left.left.left = new TreeNode(14);
		root.right.left.left.right = new TreeNode(15);

		root.right.right = new TreeNode(16);
		root.right.right.left = new TreeNode(17);
		root.right.right.right = new TreeNode(18);


		doo(root);

		System.out.println(max == 8);
	}


	public static void test6()
	{
		System.out.print("Test6: ");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);

		root.left.left.left.left = new TreeNode(12);
		root.left.left.left.right = new TreeNode(13);

		root.left.left.right.left = new TreeNode(14);
		root.left.left.right.right = new TreeNode(15);

		root.right.right.left = new TreeNode(9);
		root.right.right.right = new TreeNode(10);

		root.right.right.left.left = new TreeNode(16);
		root.right.right.left.right = new TreeNode(17);

		root.right.right.right.left = new TreeNode(18);
		root.right.right.right.right = new TreeNode(19);
		doo(root);

		System.out.println(max == 8);
	}



	public static void main(String[] args) 
	{

		test6();

	}

}
