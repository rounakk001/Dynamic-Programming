import java.util.*;

class Solution {

    public boolean canput(char c, String s){
        if(c == '0' && s.length() > 0 && s.charAt(s.length()-1) == '0')
            return false;

        return true;
    }

    public void helper(String s, List<String> result, int n){

        if(n == 0){
            result.add(s);
            return;
        }

        if(canput('0', s)){
            helper(s + '0', result, n - 1);
        }

        if(canput('1', s)){
            helper(s + '1', result, n - 1);
        }
    }

    public List<String> validStrings(int n) {

        List<String> result = new ArrayList<>();

        helper("",result,n);

        return result; 
    }
}