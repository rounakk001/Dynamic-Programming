class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        if(left.length==0) {
            int max=0;
            for(int i = 0; i < right.length;i++) {
                max = Math.max(max, n-right[i]);
            }
            return max;
        }

        
        if(right.length==0) {
            int max=0;
            for(int i=0;i<left.length;i++) {
                max=Math.max(max,left[i]);
            }
            return max;
        }

        boolean flag=false;
       int  time=0;

        while(true){
            flag=false;

            for(int i=0;i<left.length;i++){
                if(left[i]>=0)
                left[i]=left[i]-1;

                if(left[i]>=0)  //mtlb  abhi bhi ants rod pr hai
                flag=true;
            }
            for(int i=0;i<right.length;i++){
                if(right[i]<=n)
                right[i]=right[i]+1;

                if(right[i]<=n)  //mtlb abhi bhi ants rod par hai
                flag=true;
            }

            if(!flag){
                    break;
            }
            time++;
        }
        return time;
    }
}