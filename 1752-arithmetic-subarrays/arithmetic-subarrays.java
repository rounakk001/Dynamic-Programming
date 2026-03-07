class Solution {
public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

    ArrayList<Boolean> bool = new ArrayList<>();

    for (int i = 0; i < l.length; i++) {

        int[] arr = new int[r[i] - l[i] + 1];
        int ind = 0;

        for (int j = l[i]; j <= r[i]; j++) {
            arr[ind++] = nums[j];
        }

        Arrays.sort(arr);

        boolean b = true;
        int diff = arr[0] - arr[1];

        for (int j = 1; j < arr.length - 1; j++) {

            int temp = arr[j] - arr[j + 1];

            if (diff != temp) {
                b = false;
                break;
            }
        }

        bool.add(b);
    }

    return bool;
}
}