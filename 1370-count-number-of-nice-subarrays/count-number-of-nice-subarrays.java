class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int start = 0;
        int end = 0;
        int odd = 0;
        int count = 0;
        int temp = 0;

        while(end < nums.length){

            if(nums[end] % 2 == 1){
                odd++;
                temp = 0;
            }

            while(odd == k){
                temp++;

                if(nums[start] % 2 == 1)
                    odd--;

                start++;
            }

            count += temp;
            end++;
        }

        return count;
    }
}