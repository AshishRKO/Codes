
public class CoinChanging
{
	public static int count(int a[],int N)
	{
		int l=a.length;
		int arr[][]=new int[l+1][N+1];
		int i,j;
		
		for(i=0;i<=l;i++)
		{
			arr[i][0]=1;
		}
		
		
		for(i=1;i<=l;i++)
		{
			for(j=0;j<N+1;j++)
			{
				if(j<a[i-1])
				{
					arr[i][j]=arr[i-1][j];
				}
				else
				{
					arr[i][j]=arr[i-1][j]+arr[i][j-a[i-1]];
				}
			}
		}
		
		for(i=0;i<l+1;i++)
		{
			for(j=0;j<N+1;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		return arr[l][N];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3};
		System.out.println(count(a,5));

	}

}
