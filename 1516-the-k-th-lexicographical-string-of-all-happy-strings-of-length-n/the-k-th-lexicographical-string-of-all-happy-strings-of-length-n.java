import java.util.*;

class Solution {

    List<String> l = new ArrayList<>();
    String r = "";   // result store karne ke liye

    public String getHappyString(int n, int k) {

        f(n,"");

        if(k>l.size())
            return "";

        return l.get(k-1);   // lexicographically sorted already
    }

    public void f(int n, String s) {

        if(s.length()==n) {
            l.add(s);
            return;
        }

        for(char c='a';c<='c';c++) {

            // agar last character same nahi hai
            if(s.length()==0 || s.charAt(s.length()-1)!= c) {

                f(n,s + c);
            }
        }
    }
}