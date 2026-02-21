class Solution {
    public boolean canplace(int [] arr,int force,int m){
        int n=arr.length;
        int cntbowl=1,last=arr[0];

        for(int i=1;i<=n-1;i++){
            if(arr[i]-last>=force){
                cntbowl++;
                last=arr[i];
            }
        }
        if(cntbowl>=m)
        return true;
        else
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;

        int low=1,high=position[n-1]-position[0];
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;
             
            if(canplace(position,mid,m))
            {
                ans=mid;
            low=mid+1;
            }
            else
            high=mid-1;

        }
        return ans;
    }
}