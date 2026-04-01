class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m=mass;
        for(int astr:asteroids){
            if(astr<=m){
                m=m+astr;
            }
            else
            return false;
        }
        return true;
    }
}