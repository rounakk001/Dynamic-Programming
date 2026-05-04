class Solution {

    public void reverse(int arr[]){

        int temp=0;

        int l=0,r=arr.length-1;
              while(l<r){
            temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
            l++;
            r--;
           }
    }
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                if(i!=j){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }

        for(int arr[]:matrix){
            reverse(arr);
        }
        
    }
}