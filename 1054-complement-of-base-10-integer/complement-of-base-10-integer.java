class Solution {
    public int bitwiseComplement(int n) {
        String d=Integer.toBinaryString(n);

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<d.length();i++){
            if(d.charAt(i)=='1')
            sb.append('0');
            else
            sb.append('1');
        }
        String t=sb.toString();


        return Integer.parseInt(t,2);
    }
}