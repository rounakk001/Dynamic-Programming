class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<colors.length;i++){
            if(colors[i]!=colors[0]){
                max=Math.max(max,Math.abs(i));
            }

            if(colors[i]!=colors[n-1]){
                max=Math.max(max,Math.abs(n-1-i));
            }
        }
        return max;
    }
}