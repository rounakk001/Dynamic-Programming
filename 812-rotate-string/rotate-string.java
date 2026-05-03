class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length()<s.length())
        return false;
        if(goal.length()>s.length())
        return false;
        
        String result=s+s;

        if(result.contains(goal))
        return true;
        else
        return false;
    }
}