class Solution {
    public String minWindow(String s, String t) {
        int n=s.length(),m=t.length();
        int l=0,r=0;
        int minlength=Integer.MAX_VALUE , cnt=0, start=-1;

        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        while(r<s.length()){

            if(map.containsKey(s.charAt(r))){
            if(map.get(s.charAt(r))>0) cnt=cnt+1;
            map.put(s.charAt(r),map.get(s.charAt(r))-1);
            }

            while(cnt==m){   //ab yaha pe window km karenge kyuki minimum chaiye hme length
                if(r-l+1<minlength){
                    minlength=r-l+1;
                    start=l;
                }
                
                  //yaha window shrink kr rahe

                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l),map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0)
                    cnt=cnt-1;
                }

                    l++;
            }
            r=r+1;
            
         }

         return (start==-1)?"":s.substring(start,start+minlength);

        }
    }
