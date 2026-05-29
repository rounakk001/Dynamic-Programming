class Solution {
    public int majorityElement(int[] nums) {
      int answer=0;
      int count=0;

      for(int num:nums){   //count=0 ka matlab answer 2 different element ko cancel out kr rahe
        if(count==0)
        answer=num;

        if(answer==num){
            count++;
        }
        else
            count--;
      }

        return answer;
    }
  
}