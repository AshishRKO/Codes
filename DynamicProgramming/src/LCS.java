
public class LCS 
{
	public static void getLCS(String A, String B)
	{
		int r=A.length();
		int c=A.length();
		
		int a[][]=new int[r][c];
		int i,j;
		
		for(i=0;i<r;i++)
			a[0][i]=1;
		for(i=0;i<r;i++)
			a[i][0]=1;
		
		for(i=1;i<r;i++)
		{
			for(j=1;j<c;j++)
			{
				if(A.charAt(i)==B.charAt(j))
					a[i][j]=a[i-1][j-1]+1;
				else
					a[i][j]=Math.max(a[i-1][j],a[i][j-1]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
