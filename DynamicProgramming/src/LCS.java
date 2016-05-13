
public class LCS 
{
	public static int getLCS(String A, String B)
	{
		int r=A.length();
		int c=A.length();
		
		int a[][]=new int[r+1][c+1];
		int i,j;
		
		
		for(i=1;i<=r;i++)
		{
			for(j=1;j<=c;j++)
			{
				if(A.charAt(i-1)==B.charAt(j-1))
					a[i][j]=a[i-1][j-1]+1;
				else
					a[i][j]=Math.max(a[i-1][j],a[i][j-1]);
			}
		}
		return a[r][c];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		  
		 System.out.println("Length of LCS is \n"+ getLCS( X, Y) );

	}

}
