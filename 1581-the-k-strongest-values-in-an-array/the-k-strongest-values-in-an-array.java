class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int index=0;

        int m=arr[(n-1)/2];

        int result[]=new int[k];

        int left=0;
        int right=n-1;

        while(index<k){
            int diffleft=Math.abs(arr[left]-m);
            int diffright=Math.abs(arr[right]-m);

            if(diffleft>diffright){
                result[index++]=arr[left++];
            }
            else if(diffright>diffleft){
                result[index++]=arr[right--];     
            }
            else{
            //both the difference same but we choose right as it will definitely be bigger as array is sorted
            result[index++]=arr[right--];
    }
  }
  return result;

}
}
