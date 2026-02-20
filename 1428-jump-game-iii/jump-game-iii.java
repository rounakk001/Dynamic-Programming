class Solution {

    public boolean f(int idx,int[] arr, boolean[] vis){
         int n=arr.length;

        if(idx<0 || idx>=n || vis[idx])
        return false;
        
        vis[idx]=true;

        if(arr[idx]==0)
        return true;

        return f(idx+arr[idx],arr,vis) || f(idx-arr[idx],arr,vis);

    }
    public boolean canReach(int[] arr, int start) {
        boolean vis[]=new boolean[arr.length];

       return f(start,arr,vis);
    }
}