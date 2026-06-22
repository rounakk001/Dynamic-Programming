class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] arr=text.toCharArray();
        int ans=0;

        

        while(true){
            String t="balloon";

            

            for(char c:t.toCharArray()){
                    boolean flag=false;
                    
            for(int i=0;i<arr.length;i++){

                if(arr[i]==c){
                    arr[i]='#';
                    flag=true;
                    break;
                }
            }
            if(!flag) return ans;

            }
            ans++;
        }

      
    }
}