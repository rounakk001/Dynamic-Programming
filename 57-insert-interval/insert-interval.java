import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // dynamic list banayi taaki result store kar sakein
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // 1. LEFT PART: Jo intervals newInterval se pehle bina overlap ke khatam ho rahe hain
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2. MIDDLE PART (Overlapping): Jab tak intervals newInterval ke saath takra rahe hain
        // Overlap tab tak hoga jab tak current interval ka start, newInterval ke end se chota ya barabar (<=) hai
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]); // dhyan dein: yahan intervals[i][1] hoga
            i++; // index aage badhana zaroori hai varna infinite loop ho jayega
        }
        // Merge hone ke baad bane naye interval ko list mein add kiya
        res.add(newInterval);

        // 3. RIGHT PART: Jo intervals newInterval ke baad shuru ho rahe hain (no overlap)
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // List ko wapas 2D array matrix mein convert karke return kiya
        return res.toArray(new int[res.size()][]);
    }
}
