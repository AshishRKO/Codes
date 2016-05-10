
public class MinCostPath 
{
	public static int MinPath(int a[][],int m,int n)
	{
		int l=a.length;
		int i,j;
		int cost[][]=new int[m][n];
		for(i=1;i<=n;i++)
		{
			cost[0][i]=a[0][i]+cost[0][i-1];
		}
		
		for(i=1;i<=m;i++)
		{
			cost[i][0]=a[i][0]+cost[i-1][0];
		}
		
		for(i=1;i<=m;i++)
		{
			for(j=1;j<=n;j++)
			{
				cost[i][j]=Math.min(cost[i-1][j-1],Math.min(cost[i-1][j], cost[i][j-1]) )+a[i][j];
			}
		}
		
		return cost[m][n];
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a[][]={{1,2,3}, {4,8,2}, {1,5,3}};
		System.out.println(MinPath(a,2,2));
	}

}
