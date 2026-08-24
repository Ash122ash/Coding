
        class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, state)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {
        // If already marked as safe, return true
        if (state[node] == 2) {
            return true;
        }
        // If currently in the visiting cycle/path, return false (unsafe)
        if (state[node] == 1) {
            return false;
        }

        // Mark as currently visiting
        state[node] = 1;

        // Explore all neighbors
        for (int neighbor : graph[node]) {
            // If any neighbor leads to a cycle, this node is unsafe
            if (!dfs(graph, neighbor, state)) {
                return false;
            }
        }

        // All paths lead to terminal/safe nodes -> mark as safe
        state[node] = 2;
        return true;
    }
}