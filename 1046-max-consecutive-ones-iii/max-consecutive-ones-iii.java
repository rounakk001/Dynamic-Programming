class Solution {
    public int longestOnes(int[] arr, int k) {
          int cnt=0;
        int n=arr.length;
        int  l=0,r=0;
        int maxlen=0;
        while(r<n){
            if(arr[r]==0)
            {
               cnt++;
            }
            while(cnt>k){
               
                if(arr[l]==0)
                cnt--;
                l++;
            }
            if(cnt<=k)
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}
