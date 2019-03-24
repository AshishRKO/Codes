/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package Goldman;

/**
 * @author Ashish Barthwal
 * @version $Id: Solution.java, v 0.1 2019-03-23 4:22 PM Ashish Barthwal $$
 */
public class Solution {

    private static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    private static boolean isValid(int row, int col, int ROW, int COL)
    {
        // return true if row number and column number
        // is in range

        boolean res =  (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);

        if(res)
            System.out.println("i = "+row +" and j= "+col);

        return res;
    }

    static void display(int a[][], int m, int n)
    {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(a[i][j]+" ");

            }
            System.out.println();
        }

        System.out.println("---------------------------------------");
    }

    private static int minCost(int cost[][], int m, int n) {
        int i, j;
        int tc[][] = new int[m][n];

        //tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */


        tc[m-1][0]=1;

        /* Construct rest of the tc array */
        for (i = m-1; i >= 0; i--) {
            for (j = 0; j < n; j++) {

                int temp = tc[i][j];

                if(isValid(i-1,j-1,m,n))
                    tc[i-1][j-1] = tc[i][j]+tc[i-1][j-1];

                if(isValid(i-1,j,m,n))
                    tc[i-1][j] = tc[i][j]+tc[i-1][j];

                if(isValid(i-1,j+1,m,n))
                    tc[i-1][j+1] = tc[i][j]+tc[i-1][j+1]; // till top

                if(isValid(i,j+1,m,n))
                    tc[i][j+1] = tc[i][j]+tc[i][j+1];

                if(isValid(i+1,j+1,m,n))
                    tc[i+1][j+1] = tc[i][j]+tc[i+1][j+1];

                if(isValid(i+1,j,m,n))
                    tc[i+1][j] = tc[i][j]+tc[i+1][j];

                if(isValid(i+1,j-1,m,n))
                    tc[i+1][j-1] = tc[i][j]+tc[i+1][j-1];

                if(isValid(i,j-1,m,n))
                    tc[i][j-1] = tc[i][j]+tc[i][j-1];

                tc[i][j] = tc[i][j] - temp;

                display(tc,m,n);
            }

            //display(tc,m,n);
        }

        return tc[m-1][n-1];
    }

    public static long computeCount(int m, int n) {

        if(n == 1)
            return 1;
        if(n == 2)
            return 1;

        if(n == 3)
            return 2;

        if(n == 4)
            return 4;

        else
            return (long) Math.pow(2,n-2);






    }

    public static void main(String[] args) {
        int cost[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 0, 0 } };
        System.out.println(minCost(cost, 4, 3));
        System.out.println("dgfg");
    }
}