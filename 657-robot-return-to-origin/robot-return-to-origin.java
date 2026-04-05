class Solution {
    public boolean judgeCircle(String moves) {
        int i=0,j=0;
       for(char c:moves.toCharArray()){
        if(c=='L'){
            j--;
        }
        else if(c=='R'){
            j++;
        }
        else if(c=='D'){
            i++;
        }
        else if(c=='U'){
            i--;
        }
       } 
       return (i==0 && j==0);
    }
}