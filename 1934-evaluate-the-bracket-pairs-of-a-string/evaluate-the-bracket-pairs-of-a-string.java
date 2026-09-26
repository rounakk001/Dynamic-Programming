import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // 1. Saari knowledge ko HashMap mein daal dein taaki O(1) time mein search ho sake
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = s.length();

        // 2. String ko ek hi baar mein scan karein (O(N) Time Complexity)
        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Bracket shuru hua, toh andar ki key dhoondhein
                int start = i + 1;
                while (s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(start, i); // Bracket ke andar ka text

                // Map se value nikaalein, agar nahi hai toh "?" use karein
                result.append(map.getOrDefault(key, "?"));
            } else {
                // Agar normal character hai toh bina badle add karein
                result.append(ch);
            }
            i++; // Agle character par jayein
        }

        return result.toString();
    }
}
