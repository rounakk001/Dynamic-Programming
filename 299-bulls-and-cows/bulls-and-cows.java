class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int A = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {

                map1.put(secret.charAt(i), map1.getOrDefault(secret.charAt(i), 0) + 1);

                map2.put(guess.charAt(i), map2.getOrDefault(guess.charAt(i), 0) + 1);

            }
        }

        int B = 0;

        for (char ch : map1.keySet()) {
            if (map2.containsKey(ch)) {
                B += Math.min(map1.get(ch), map2.get(ch));
            }
        }

        return A + "A" + B + "B";
    }
}