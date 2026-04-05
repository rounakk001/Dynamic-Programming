class Solution {
    public boolean judgeCircle(String moves) {
        int i=0,j=0;
       for(int k=0;k<moves.length();k++){
        if(moves.charAt(k)=='L'){
            j=j-1;
        }
        if(moves.charAt(k)=='R'){
            j=j+1;
        }
        if(moves.charAt(k)=='D'){
            i=i+1;
        }
        if(moves.charAt(k)=='U'){
            i=i-1;
        }
       } 
       if(i==0 && j==0)
       return true ;
       else
       return false;
    }
}