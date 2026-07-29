class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        

        int maxlen=0;

        for(int key:set){

            if(!set.contains(key+1)){
                int end=key;
                int count=1;

             while(set.contains(end-1)){
                 end--;
                count++;
            }
            maxlen=Math.max(maxlen,count);
            }
        }

        return maxlen;

        
    }
}