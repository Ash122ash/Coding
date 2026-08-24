class Solution {
    public boolean isBipartite(int[][] graph) {


        int n = graph.length;
        // color array: 0 = uncolored, 1 = Color A, -1 = Color B
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            // If already colored, skip (handles disconnected components)
            if (color[i] != 0) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1; // Start coloring node i with Color 1

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int neighbor : graph[curr]) {
                    // Case 1: Neighbor has the SAME color -> Not bipartite
                    if (color[neighbor] == color[curr]) {
                        return false;
                    }

                    // Case 2: Neighbor is not yet colored -> Assign opposite color
                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[curr]; // Flips 1 to -1, or -1 to 1
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return true;
    }
}