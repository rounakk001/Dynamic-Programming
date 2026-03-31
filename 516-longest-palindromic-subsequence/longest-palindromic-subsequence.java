class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2="";

        for(char c:s1.toCharArray()){
         s2+=c;
        }
        s2=new StringBuilder(s2).reverse().toString();
    
        int dp[][]=new int[s1.length()+1][s2.length()+1];

        int n=s1.length();
        int m=s2.length();

        //if(i==0 || j==0) return 0 --- base case

        for(int j=0;j<=m;j++) dp[0][j]=0;
        for(int i=0;i<=n;i++) dp[i][0]=0;

        //copy the recurrence
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //match case
                if(s1.charAt(i-1)==s2.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];

                //not match
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}