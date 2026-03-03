import java.util.*;

class Solution {
    public int numberOfBeams(String[] bank) {

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<bank.length;i++) {     
            int d=0;

            for(char c:bank[i].toCharArray()) {
                if(c=='1')
                    d++;
            }

            if(d>0)   // sirf non-zero rows store karenge
                arr.add(d);
        }

        int b=0;

        for(int i=1;i<arr.size();i++) {
            b+= arr.get(i-1)*arr.get(i);
        }

        return b;
    }
}