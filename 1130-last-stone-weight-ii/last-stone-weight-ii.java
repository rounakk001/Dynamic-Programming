class Solution {
    public int lastStoneWeightII(int[] stones) {
    int totalsum=0;
    for(int num:stones){
        totalsum+=num;
    }
     int n=stones.length;
     int k=totalsum/2;

    boolean dp[][]=new boolean[n][totalsum+1];

    //base case 
     for(int i=0;i<n;i++){
        dp[i][0]=true;
     }

     if(stones[0]<=k){
        dp[0][stones[0]]=true;
     }

     for(int i=1;i<n;i++){
        for(int target=1;target<=k;target++){
            boolean nottake=dp[i-1][target];

            boolean take=false;
            if(target>=stones[i])
            take=dp[i-1][target-stones[i]];
        
        dp[i][target]=take||nottake;
        }
     }

     int min=(int)1e9;

     for(int i=0;i<=totalsum/2;i++){
        if(dp[n-1][i]==true){
             int s1=i;
             int s2=totalsum-i;

             min=Math.min(min,Math.abs(s1-s2));
        }
     }
     return min;
    }
}