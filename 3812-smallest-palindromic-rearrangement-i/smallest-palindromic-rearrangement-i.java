class Solution {

    public String reverse(String s){
        StringBuilder sb=new StringBuilder(s);
        return new String(sb.reverse());
    }

    public String smallest(String s){
        int count[]=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<26;i++){
            while(count[i]>0){
                sb.append((char)(i+'a'));
                count[i]--;
            }
        }

        return new String(sb);
    }

    public String smallestPalindrome(String s) {
        StringBuilder ans=new StringBuilder();
        if(s.length()==1){
            return s;
        }
        int len=s.length();


        if(len%2==0){  //odd length
        int ind=len/2;
        StringBuilder sb=new StringBuilder(s.substring(0,ind));
        String halfString=smallest(new String(sb));
        String reverseString=reverse(halfString);

        ans.append(halfString);
        ans.append(reverseString);

        return new String(ans);
        }
        else{

        int ind=len/2;
        StringBuilder sb=new StringBuilder(s.substring(0,ind));
        String halfString=smallest(new String(sb));
        String reverseString=reverse(halfString);

        ans.append(halfString);
        ans.append(s.charAt(ind));
        ans.append(reverseString);

        return new String(ans);

        }
    }
}