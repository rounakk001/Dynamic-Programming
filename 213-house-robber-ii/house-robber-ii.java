class Solution {

    public int robLinear(int[] nums,int start,int end) {

        int prev=nums[start];
        int prev2 =0;

        for(int i = start+1;i<=end;i++) {

            int take=nums[i];
            if(i>start+0)
                take+=prev2;

            int nottake=0+prev;

            int curri=Math.max(take,nottake);

            prev2=prev;
            prev=curri;
        }

        return prev;
    }

    public int rob(int[] nums) {

        int n=nums.length;

        if(n==1)
            return nums[0];

        int c1 = robLinear(nums, 0, n - 2); // first ko le rahe
        int c2 = robLinear(nums, 1, n - 1); // last ko le rahe

        return Math.max(c1, c2);
    }
}