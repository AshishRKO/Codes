class Height {
    int h;
}

public class Diameter {
    // Complexity - O(n)
    public static int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        int ld = diameter(root.left);
        int rd = diameter(root.right);

        return Math.max(lh + rh + 1, Math.max(ld, rd));

    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;

        int l = height(root.left);
        int r = height(root.right);

        return Math.max(l, r) + 1;
    }

    public static int fastDiameter(TreeNode root, Height height) {
        Height lh = new Height();
        Height rh = new Height();

        if (root == null) {
            height.h = 0;
            return 0;
        }

        int ld = fastDiameter(root.left, lh);
        int rd = fastDiameter(root.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter = " + fastDiameter(root, new Height()));

    }

}
