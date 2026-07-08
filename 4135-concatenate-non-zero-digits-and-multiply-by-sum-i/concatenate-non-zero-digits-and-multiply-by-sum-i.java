class Solution {
    public long sumAndMultiply(int n) {
        Queue<Integer> q = new LinkedList<>();

        while (n != 0) {
            int x = n % 10;
            if (x != 0) {
                q.add(x);
            }
            n = n / 10;
        }
        long sum = 0;
        long x = 0;
        long mul = 1;
        long prev = 0;
        while (!q.isEmpty()) {
            sum += q.peek();
            x = q.peek() * mul + prev;
            q.remove();

            mul *= 10;
            prev = x;
        }

        return sum * x;
    }
}