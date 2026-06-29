class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int c=0;
        for(String ch:patterns){
            if(word.indexOf(ch)!=-1){
                c++;
            }
        }
        return c;
    }
}