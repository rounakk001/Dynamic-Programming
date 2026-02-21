import java.util.*;

class Solution {
    public int minimizedMaximum(int n, int[]quantities) {
        int low=1;
        int high=0;
        
        for(int q:quantities) 
            high=Math.max(high, q);
        
        int ans=high;
        
        while(low<=high) {
            int mid=low+(high-low)/2;
            
            long stooree=0;

            for(int q:quantities) 
                stooree+=(q+mid-1)/mid;
            
            if(stooree<=n) {
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            
        }
        
        }
        return ans;
    }
}