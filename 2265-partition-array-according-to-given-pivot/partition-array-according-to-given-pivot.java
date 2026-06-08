class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        List<Integer> lessarr = new ArrayList<>();
        List<Integer> equalarr = new ArrayList<>();
        List<Integer> morearr = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) lessarr.add(num);
            else if (num == pivot) equalarr.add(num);
            else morearr.add(num);
        }

        int[] ans = new int[nums.length];
        int index = 0;

        for (int num : lessarr) ans[index++] = num;
        for (int num : equalarr) ans[index++] = num;
        for (int num : morearr) ans[index++] = num;

        return ans;
    }
}
