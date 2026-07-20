class Solution {
    public String rearrangeString(String s, char x, char y) {
        if(s.indexOf(x)==-1)
            return s;
        StringBuilder st=new StringBuilder(s);
        if(s.indexOf(y)==-1){
           return st.reverse().toString();
        }

        
        HashMap<Character,Integer> map=new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        StringBuilder sb=new StringBuilder();

        for(char key:map.keySet()){
            while(map.get(y)!=0){
                sb.append(y);
                map.put(y,map.get(y)-1);
            }
        }

        for(char c:s.toCharArray()){
            if(c!=y){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}