import java.util.*;

class Solution {
    static class State {
        int node;
        Set<Integer> visited;

        State(int node, Set<Integer> visited) {
            this.node = node;
            this.visited = visited;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        Queue<State> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        // Multi-source BFS
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            State s = new State(i, set);
            q.offer(s);
            seen.add(i + "-" + set.toString());
        }

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                State curr = q.poll();

                // If all nodes visited
                if (curr.visited.size() == n) {
                    return steps;
                }

                for (int nei : graph[curr.node]) {
                    Set<Integer> newSet = new HashSet<>(curr.visited);
                    newSet.add(nei);

                    String key = nei + "-" + newSet.toString();
                    if (!seen.contains(key)) {
                        seen.add(key);
                        q.offer(new State(nei, newSet));
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}