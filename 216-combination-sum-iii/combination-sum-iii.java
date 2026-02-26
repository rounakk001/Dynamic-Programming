class Solution {

    public void helper(int idx, int k, int target,
                       List<Integer> ds,
                       List<List<Integer>> ans) {

        // Base case
        if (k==0 && target==0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Agar k khatam ya target negative ho gaya
        if (k==0 || target<0) return;

        for (int i =idx; i<=9; i++) {

            if (i >target) break;  //unnecessary recursion rok rahe

            ds.add(i);
            helper(i+1, k-1,target-i,ds,ans);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        helper(1,k,n,ds,ans);
        return ans;
    }
}