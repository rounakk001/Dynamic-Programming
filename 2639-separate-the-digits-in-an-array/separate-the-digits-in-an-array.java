class Solution {
    public int[] separateDigits(int[] nums) {
       
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            Stack<Integer> s=new Stack<>();
            while(nums[i]!=0){
                int x=nums[i]%10;
                s.push(x);
                nums[i]=nums[i]/10;
            }

            while(!s.isEmpty())
            arr.add(s.pop());
            
        }
        int res[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }

}