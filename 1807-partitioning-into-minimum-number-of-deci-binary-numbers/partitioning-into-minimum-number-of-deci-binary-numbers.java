class Solution {
    public int minPartitions(String n) {
        int maxdigit=0;
        for(int i=0;i<n.length();i++){
            int d=n.charAt(i)-'0';

            if(d>maxdigit){
                maxdigit=d;
            }

            
        }
        return maxdigit;
    }
}