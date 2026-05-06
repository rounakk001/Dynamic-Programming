class Solution {
     public String frequencySort(String s) {
        HashMap<Character,Integer> map= new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((x,y)->(map.get(y)-map.get(x)));

        pq.addAll(map.keySet());

        StringBuilder res=new StringBuilder();

        while(!pq.isEmpty()){
            char c=pq.poll();
            
                while(map.get(c)!=0){
                res.append(c);
                map.put(c,map.get(c)-1);
                }
            
        }

        return res.toString();
    }
}