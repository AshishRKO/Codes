
public class EditDistance 
{
	public static int minDistance(String A, String B) 
	{
        int m=A.length();
        int n=B.length();
        
        int dp[][]=new int[m+1][n+1]; 
        int i,j;
        
        for(i=0;i<n+1;i++)
        {
        	dp[0][i]=i;
        }
        for(i=0;i<m+1;i++)
        {
        	dp[i][0]=i;
        }
        
        for(i=1;i<m+1;i++)
        {
        	for(j=1;j<n+1;j++)
        	{
        		if(A.charAt(i-1)==B.charAt(j-1))
        			dp[i][j]=dp[i-1][j-1];
        		else
        			dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
        	}
        }
        
        return dp[m][n]; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "sunday";
	    String str2 = "saturday";
	    System.out.println(minDistance(str1,str2));

	}

}
