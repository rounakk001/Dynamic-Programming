class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<=n;i++) dp[i][0]=0;   //base case
        for(int j=0;j<=m;j++) dp[0][j]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                ///match case
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else  //not match 
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        //yaha pe dp table bn ke ready hai ab khelo printing ke saath

        int i=n,j=m;
        StringBuilder s=new StringBuilder();

        while(i>0 &&j>0){
              if(s1.charAt(i-1)==s2.charAt(j-1)){
                s.append(s1.charAt(i-1));
                i--;
                j--;
              }
              else if(dp[i-1][j]>dp[i][j-1]){
                s.append(s1.charAt(i-1));
                i--;
              }
              else
              {
                s.append(s2.charAt(j-1));
                j--;
              }
        }
        //ho sakta hai kayi character bach jayenge ya to s1 ke ya to s2 ke
        while(i>0){
            s.append(s1.charAt(i-1));
            i--;
        }

        while(j>0){
            s.append(s2.charAt(j-1));
            j--;
        }

          return s.reverse().toString();
    }
}