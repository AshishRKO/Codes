//{10,22,9,33,21,50,41,60,80}
// {10,22,33,50,60,80}
public class LongestIncreasingSubsequence 
{
	//Complexity - On(n^2)
	public static void LIS(int a[])
	{
		int l=a.length;
		int i,j;
		
		int b[]=new int[l];
		for(i=0;i<l;i++)
		{
			b[i]=1;
		}
		
		for(i=0;i<l;i++)
		{
			for(j=0;j<i;j++)
			{
				if(a[j]<a[i] && b[i]<b[j]+1)
					b[i]=b[j]+1;
			}
		}
		
		int max=b[0];
		for(i=0;i<l;i++)
		{
			if(max<b[i])
				max=b[i];
			System.out.print(b[i]+" ");
		}
		System.out.println("\nLength of the longest increasing subsequence= "+max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[]={10,22,9,33,21,50,41,60,80};
		int a[]={-2,-1};
		LIS(a);

	}

}
