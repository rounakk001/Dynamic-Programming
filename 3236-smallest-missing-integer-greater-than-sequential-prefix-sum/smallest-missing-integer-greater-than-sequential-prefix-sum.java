class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans=0;

        int left = 0;
        int maxcount = Integer.MIN_VALUE;
        int sum = 0;
        
        boolean flag = true;
        HashMap<Integer,Integer> map=new HashMap<>();
       int currsum=0;
        while (left < nums.length) {

            sum = 0;
            int cnt = 0;

            while(left < nums.length - 1 && nums[left] + 1 == nums[left + 1]) {
                sum += nums[left];
                cnt++;
                left++;
            }

            cnt++;
            sum+=nums[left];
            left++;
            break;
           
        }

      for(int i=sum;i<Integer.MAX_VALUE;i++){
        if(!set.contains(i)){
            return i;
        }
      }

        return 0;
    }
}