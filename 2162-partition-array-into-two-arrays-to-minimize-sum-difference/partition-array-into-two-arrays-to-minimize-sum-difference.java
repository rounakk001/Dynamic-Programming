import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;

        // array ko do equal halves me tod diya
        int[] leftHalf  = Arrays.copyOfRange(nums, 0, n);
        int[] rightHalf = Arrays.copyOfRange(nums, n, 2 * n);

        // yaha hum store karenge subset sums
        // index represent karega kitne elements liye
        List<List<Integer>> leftSums  = new ArrayList<>();
        List<List<Integer>> rightSums = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            leftSums.add(new ArrayList<>());
            rightSums.add(new ArrayList<>());
        }

        // left half ke saare subset sums generate kar rahe hain
        for (int mask = 0; mask < (1 << n); mask++) {

            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {

                // agar ith bit set hai to element include karenge
                if ((mask & (1 << i)) != 0) {
                    sum += leftHalf[i];
                    count++;
                }
            }

            // count ke hisaab se sum store kar diya
            leftSums.get(count).add(sum);
        }

        // right half ke saare subset sums generate kar rahe hain
        for (int mask = 0; mask < (1 << n); mask++) {

            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    sum += rightHalf[i];
                    count++;
                }
            }

            rightSums.get(count).add(sum);
        }

        int totalSum = 0;

        // pura array ka total sum nikal liya
        for (int num : nums) {
            totalSum += num;
        }

        int minDiff = Integer.MAX_VALUE;

        // hum k elements left se lenge
        // to (n-k) right se lene padenge
        for (int k = 0; k <= n; k++) {

            List<Integer> list1 = leftSums.get(k);
            List<Integer> list2 = rightSums.get(n - k);

            // binary search ke liye sort karna zaroori
            Collections.sort(list2);

            for (int s1 : list1) {

                // hume totalSum/2 ke closest jaana hai
                int target = totalSum / 2 - s1;

                int idx = Collections.binarySearch(list2, target);

                if (idx < 0) {
                    idx = -idx - 1;
                }

                // closest element check karenge
                if (idx < list2.size()) {

                    int combinedSum = s1 + list2.get(idx);

                    minDiff = Math.min(
                        minDiff,
                        Math.abs(totalSum - 2 * combinedSum)
                    );
                }

                // ek element pehle wala bhi check karenge
                if (idx > 0) {

                    int combinedSum = s1 + list2.get(idx - 1);

                    minDiff = Math.min(
                        minDiff,
                        Math.abs(totalSum - 2 * combinedSum)
                    );
                }
            }
        }

        return minDiff;
    }
}