class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        if(nums.length==0) return "";
        String strnums[]=new String[nums.length];

        for(int i=0;i<nums.length;i++){
            strnums[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(strnums,(a,b)->(b+a).compareTo(a+b)); //sorted accordingly

          // Edge case: if all elements are 0 sortiing ke baad agar snse aage 0 hai iska mtlb peeche saare chote ya barabar hi hai to seedhe 0 return kr do
        if (strnums[0].equals("0")) {
            return "0";
        }



        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(strnums[i]);
        }

        return sb.toString();
    }
}