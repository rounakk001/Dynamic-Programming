class Solution {
    int dp[][];
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp=new int[nums1.length][nums2.length];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(nums1.length- 1,nums2.length-1,nums1,nums2);
    }
    
    public int helper(int ind1,int ind2,int nums1[],int nums2[]){
        
        if(ind1<0 || ind2<0){
            return 0;
        }

        if(dp[ind1][ind2]!=-1)
        return dp[ind1][ind2];

        if(nums1[ind1]==nums2[ind2]){
            return dp[ind1][ind2]=1+helper(ind1-1,ind2-1,nums1,nums2);
        }
        else{
            return dp[ind1][ind2]=0+Math.max(helper(ind1-1,ind2,nums1,nums2),helper(ind1,ind2-1,nums1,nums2));
        }
    }
    
}