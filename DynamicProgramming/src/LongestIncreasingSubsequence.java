//{10,22,9,33,21,50,41,60,80}
// {10,22,33,50,60,80}
public class LongestIncreasingSubsequence 
{
	public static void LIS(int a[])
	{
		int l=a.length;
		int i;
		
		int b[]=new int[l];
		for(i=0;i<l;i++)
		{
			b[i]=1;
		}
		
		for(i=1;i<l;i++)
		{
			if(a[i-1]<a[i])
			{
				b[i]=b[i-1]+1;
			}
			else
				b[i]=b[i-1];
		}
		
		for(i=0;i<l;i++)
		{
			System.out.print(b[i]+" ");
		}
		System.out.println("\nLength of the longest subsequence= "+b[l-1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={10,22,9,33,21,50,41,60,80};
		LIS(a);

	}

}
