class Solution {
    public String reverse(String s){
        int start=0, end=s.length()-1;
        char[] t=s.toCharArray();
        while(start<=end){
            char c=t[end];
            t[end]=t[start];
            t[start]=c;
            start++;
            end--;
        }
        return new String(t);
    }
    public String invert(String s){
        char[] t=s.toCharArray();
        for(int i=0;i<t.length;i++){
            if(t[i]=='0')
                t[i]='1';
            else
                t[i]='0';
        }
        return new String(t);
    }
    public char findKthBit(int n, int k) {
          String olds="0";
          String news="";
          for(int i=1;i<=n;i++){
             news=olds+"1"+reverse(invert(olds));
             olds=news;
             
          }
          return news.charAt(k-1);
    }
}