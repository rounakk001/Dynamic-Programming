class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] result = new int[n];

        for(int i=0;i<n;i++) {
            int c=0;

            for(int j=0;j<n;j++) {
                if(boxes.charAt(j)=='1') {
                    c+= Math.abs(i-j);
                }
            }

            result[i]=c;
        }

        return result;
    }
}