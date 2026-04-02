class Solution {
    int dp[][][];
    public int maximumAmount(int[][] coins) {
        int m=coins.length;
        int n=coins[0].length;

        dp=new int[m][n][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    Arrays.fill(dp[i][j],Integer.MIN_VALUE);
                }
            }
        return helper(m-1,n-1,2,coins);
    }

    public int helper(int i,int j,int k,int [][] coins){

        if(i<0 || j<0)
        return -(int)1e9;
        
        if(i==0 && j==0 ){
            if(coins[i][j]<0 && k>0){
              return 0;
            }

            return coins[i][j];
        }
          
           if(dp[i][j][k]!=Integer.MIN_VALUE) return dp[i][j][k];

        int left=helper(i,j-1,k,coins);
       int  up=helper(i-1,j,k,coins);

       int res=-(int)1e9;

        if(coins[i][j]>=0){

            if(left!=-(int)1e9) res=Math.max(res,left+coins[i][j]);
            if(up!=-(int)1e9) res=Math.max(res,up+coins[i][j]);

        }else{

             if(k>0){
                int left2=helper(i,j-1,k-1,coins);
                int up2=helper(i-1,j,k-1,coins);
                res=Math.max(res,left2);
                res=Math.max(res,up2);
            }

            if(left!=-(int)1e9) res=Math.max(res,left+coins[i][j]);
            if(up!=-(int)1e9) res=Math.max(res,up+coins[i][j]);

           
        }

       
          return dp[i][j][k]=res;
        

    }
}