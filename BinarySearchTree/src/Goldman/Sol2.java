/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package Goldman;

import java.util.*;

/**
 * @author Ashish Barthwal
 * @version $Id: Sol2.java, v 0.1 2019-03-23 5:06 PM Ashish Barthwal $$
 */
public class Sol2 {


    public static long computeCount(int m, int n) {

        if(n==1 && m==1)
            return 0;

        if(n == 1 || m==1)
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

    static class Ele
    {
        int x = 0;
        int y = 0;
        int value = 0;
        Ele(int x,int y, int value)
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    // function to check whether a cell is valid / invalid
    static boolean isValid(int i, int j, int m, int n, boolean visted[][])
    {
        return (i >= 0 && j >= 0 && i < m && j < n && !visted[i][j]);
    }


    // Function to check whether the cell is delimiter
    // which is (-1, -1)
    static boolean isDelim(Ele temp)
    {
        return (temp.x == -1 && temp.y == -1);
    }



    // This function finds if it is possible to rot all oranges or not.
    // If possible, then it returns minimum time required to rot all,
    // otherwise returns -1
    static int rotOranges(int arr[][], int m, int n)
    {
        // Create a queue of cells
        Queue<Ele> Q=new LinkedList<>();
        Ele temp;
        int ans = 0;

        Q.add(new Ele(m-1,0, 1));

        // Separate these rotten oranges from the oranges which will rotten
        // due the oranges in first time frame using delimiter which is (-1, -1)
        Q.add(new Ele(-1,-1, 0));

        int cnt = 0;

        boolean visted[][] = new boolean[m][n];

        // Process the grid while there are rotten oranges in the Queue
        while(!Q.isEmpty())
        {
            boolean flag = false;

            // Process all the rotten oranges in current time frame.
            while(!isDelim(Q.peek()))
            {
                temp = Q.peek();
                visted[temp.x][temp.y] = true;

                int tempData = temp.value;

                // Check right adjacent cell that if it can be rotten
                if(isValid(temp.x+1, temp.y, m,n, visted) )
                {
                    if(!flag)
                    {
                        // if this is the first orange to get rotten, increase
                        // count and set the flag.
                        ans++;
                        flag = true;
                    }
                    // Make the orange rotten
                    arr[temp.x+1][temp.y] = arr[temp.x+1][temp.y] + temp.value;

                    // push the adjacent orange to Queue
                    Q.add(new Ele(temp.x+1,temp.y,arr[temp.x+1][temp.y]));

                }

                // Check left adjacent cell that if it can be rotten
                if (isValid(temp.x-1, temp.y, m, n, visted) )
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x-1][temp.y] = arr[temp.x-1][temp.y] + temp.value;
                    Q.add(new Ele(temp.x-1,temp.y, arr[temp.x-1][temp.y])); // push this cell to Queue
                }

                if (isValid(temp.x, temp.y+1, m, n, visted)) {
                    if(!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y+1] = arr[temp.x][temp.y+1] + temp.value;
                    Q.add(new Ele(temp.x,temp.y+1, arr[temp.x][temp.y+1])); // Push this cell to Queue
                }

                if (isValid(temp.x, temp.y-1, m, n, visted) )
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y-1] = arr[temp.x][temp.y-1] + temp.value;
                    Q.add(new Ele(temp.x,temp.y-1, arr[temp.x][temp.y-1])); // push this cell to Queue
                }

                // -------------------
                if (isValid(temp.x-1, temp.y-1, m, n, visted) )
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x-1][temp.y-1] = arr[temp.x-1][temp.y-1] + temp.value;
                    Q.add(new Ele(temp.x-1,temp.y-1, arr[temp.x-1][temp.y-1])); // push this cell to Queue
                }

                if (isValid(temp.x+1, temp.y+1, m, n, visted) )
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x+1][temp.y+1] = arr[temp.x+1][temp.y+1] + temp.value;
                    Q.add(new Ele(temp.x+1,temp.y+1, arr[temp.x+1][temp.y+1])); // push this cell to Queue
                }

                if (isValid(temp.x-1, temp.y+1, m, n, visted) )
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x-1][temp.y+1] = arr[temp.x-1][temp.y+1] + temp.value;
                    Q.add(new Ele(temp.x-1,temp.y+1, arr[temp.x-1][temp.y+1])); // push this cell to Queue
                }

                if (isValid(temp.x+1, temp.y-1, m, n, visted) )
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x+1][temp.y-1] = arr[temp.x+1][temp.y-1] + temp.value;
                    Q.add(new Ele(temp.x+1,temp.y-1, arr[temp.x+1][temp.y-1])); // push this cell to Queue
                }

                Q.remove();

                if(!isDelim(temp) && flag == true) {
                    //System.out.println("x = "+temp.x+" and y = "+temp.y);
                    arr[temp.x][temp.y] = arr[temp.x][temp.y] - tempData;
                }

            }

            display(arr, m, n);
            cnt++;

            if(cnt == n-1)
            {
                return arr[m-1][n-1];
            }
            // Pop the delimiter
            Q.remove();

            // If oranges were rotten in current frame than separate the
            // rotten oranges using delimiter for the next frame for processing.
            if (!Q.isEmpty())
            {
                Q.add(new Ele(-1,-1, -1));
            }

            // If Queue was empty than no rotten oranges left to process so exit
        }

        // Return -1 if all arranges could not rot, otherwise -1.s
        return ans;

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

    // Drive program
    public static void main(String[] args)
    {
        long ans = computeCount(2,1);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }
}