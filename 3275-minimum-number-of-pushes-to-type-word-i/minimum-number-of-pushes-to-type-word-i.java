class Solution {
    public int minimumPushes(String word) {
        if(word.length()<=8){
            return  word.length();
        }
       
       int q=word.length()/8;
       int r=word.length()%8;

       if(q==3){
        return 48 +r*4;
       }
       if(q==2){
        return 24+r*3;
       }
       if(q==1){
        return 8+r*2;
       }
       return 0;
    }
}