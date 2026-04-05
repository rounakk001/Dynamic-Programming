class Solution {
    public int[] executeInstructions(int n, int[] start, String s) {

     
        
        int arr[]=new int[s.length()];

        
       
         
         for(int k=0;k<s.length();k++){
            int i=start[0],j=start[1];
             int d=0;
            for(int t=k;t<s.length();t++){
                if(s.charAt(t)=='R'){
                   j++;

                    if(j>=n)
                   break;
                   d++;
                   arr[k]=d;
                }
                else if(s.charAt(t)=='D'){
                   i++;

                    if(i>=n)
                   break;
                   d++;
                   
                   arr[k]=d;
                }
                else if(s.charAt(t)=='L'){
                   j--;

                    if(j<0)
                   break;
                   d++;
                   arr[k]=d;
                }
                else if(s.charAt(t)=='U'){
                   i--;

                    if(i<0)
                   break;
                   d++;
                   arr[k]=d;
                }
            }
         }
         return arr;
    }
}