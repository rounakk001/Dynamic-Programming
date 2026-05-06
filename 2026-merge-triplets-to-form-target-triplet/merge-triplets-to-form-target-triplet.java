class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean flag = true;
        
        for (int j = 0; j < triplets[0].length; j++) {
            int a1 = 0;
            for (int i = 0; i < triplets.length; i++) {
                if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                    if (triplets[i][j] == target[j]) {
                        a1 = triplets[i][j];
                        break;
                    }
                }
            }
            if (a1 != target[j]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}