class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
    long left = 1;  // → Minimum possible time (at least 1 second)
    
    int min_time = Integer.MAX_VALUE;
    for (int wt : workerTimes) {
        min_time = Math.min(min_time, wt);  // → Find the fastest worker
    }
    
    long right = (long)min_time * (long)mountainHeight * (mountainHeight + 1) / 2;
    // → Upper bound: if the fastest worker does everything alone
    // → sum = min_time * (1+2+...+mountainHeight) = min_time * mountainHeight*    (mountainHeight+1)/2
    long answer = right;  // → Initially set answer to the upper bound
        while (left <= right) {
        long mid = left + (right - left) / 2;  // → Candidate time to test
        
        if (can_achieve(mid, mountainHeight, workerTimes)) {
            answer = mid;          // → It's possible, try to find smaller
            right = mid - 1;
        } else {
            left = mid + 1;        // → Not possible, need more time
        }
    }
    
    return answer;
}
private boolean can_achieve(long time, int mountainHeight, int[] workerTimes) {
    long total_height = 0;  // → Total units removed by all workers in 'time' seconds
    
    for (int wt : workerTimes) {
        // For a worker with multiplier wt, we need max x such that wt * x*(x+1)/2 ≤ time
        // Solve quadratic: x² + x - 2*time/wt ≤ 0
        double D = 1 + 8.0 * time / wt;  // → discriminant = 1 + 8T/wt
        long x = (long)((-1 + Math.sqrt(D)) / 2);  // → positive root, floor
        // x is the maximum units this worker can complete in 'time' seconds
        
        total_height += x;
        
        if (total_height >= mountainHeight) return true;  // → early exit
    }
    
    return total_height >= mountainHeight;
}
}
