class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int pref[]=new int[A.length];
        int count[]=new int[A.length+1];

       

        for(int i=0;i<A.length;i++){
            

            count[A[i]]++;
            count[B[i]]++;
            
            int c=0;

           for(int j=1;j<count.length;j++){
            if(count[j]>1)
            c++;
           }

            pref[i]=c;

           
            
        }
        return pref; 
    }
}