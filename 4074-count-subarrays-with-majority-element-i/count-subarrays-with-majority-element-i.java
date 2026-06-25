class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;

        int pre[]=new int[n+1];

        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+(nums[i]==target?1:-1);
        }

        int ans=0;

        for(int l=0;l<n;l++){
            for(int r=l;r<n;r++){
                if(pre[r+1]-pre[l]>0){
                    ans++;
                }
            }
        }

        return ans;
    }
}