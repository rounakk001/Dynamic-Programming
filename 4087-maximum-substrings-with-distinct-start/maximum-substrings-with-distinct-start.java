class Solution {
    public int maxDistinct(String s) {
        HashSet<Character> set=new HashSet<>();
        char d[]=s.toCharArray();
        for(char c:d){
            set.add(c);
        }

        return set.size();
    }
}