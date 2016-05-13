
public class CoinChange 
{
	public static int count(int a[])
	{
		int l=a.length;
		int arr[][]=new int[l][];
		int i,j;
		
		for(i=0;i<l;i++)
		{
			for(j=0;j<l;i++)
			{
				arr[i][j]=a[i]+Math.min(arr[i][j-1],arr[i-1][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
