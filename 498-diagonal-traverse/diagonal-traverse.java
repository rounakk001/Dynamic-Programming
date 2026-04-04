class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int arr[]=new int[m*n];

        int k=0;

        boolean flag=true;

        int i=0,j=0;

        while(k<m*n){
            arr[k++]=mat[i][j];
            if(flag)
            {
                i=i-1;
                j=j+1;
            }
            else
            {
                i=i+1;
                j=j-1;
            }
              if(j>=n){
                j=j-1;
                i+=2;
                flag=!flag;
            }
           else if(i<0 )  //ye upar jaate waqt ke liye
            {
               i=0;

               flag=!flag;
                
            }

             else if(i>=m){
                i=i-1;
                j+=2;   //neche jaate waqt tumne j=j-1 kiya tha is liye
                flag=!flag;
            }
            
            else if(j<0){
               
                j=0;
                flag=!flag;
            }

           

           
        

            

        }
        return arr;
    }
}