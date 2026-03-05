class Solution {
    public int minSwaps(String s) {

        char[] arr=s.toCharArray();
        int n=arr.length;

        int left=0;
        int right=n-1;
        int bal=0;
        int c=0;

        while(left<n){

            if(arr[left]=='['){
                bal++;
            } else{
                bal--;
            }

            
            if(bal<0) {
                
                  while(arr[right]!='[') {
                    right--;
                }

              
                char temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;

                c++;
                bal = 1;
                right--;
            }
            left++;
        }

        return c;
    }
}