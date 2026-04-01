class Solution {
    public int countCollisions(String s) {

        int n=s.length();
        int i=0,j=n-1;
         

         //pehle ke L skip kar do
         while(i<n && s.charAt(i)=='L'){
            i++;
         }

         //last ke R skip kar do
         while(j>=0 && s.charAt(j)=='R'){
            j--;
         }

         int collisions=0;
         for(int k=i;k<=j;k++){
            if(s.charAt(k)!='S')
            collisions++;
         }

         return collisions;
        
    }
}