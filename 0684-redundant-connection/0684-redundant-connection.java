class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        // 1. Initialize the adjacency list using List<List<Integer>>
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n + 1];
        
        // Add n + 1 empty lists to handle 1-based indexing (nodes 1 to n)
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 2. Populate the adjacency list and calculate degrees
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            // Use .get() instead of array brackets
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        
        // 3. Initialize Queue and Boolean Array
        Queue<Integer> queue = new LinkedList<>();
        boolean[] inCycle = new boolean[n + 1];
        
        // Assume all nodes are part of a cycle initially
        Arrays.fill(inCycle, true);
        
        // 4. Add all leaf nodes (degree == 1) to the queue
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        
        // 5. Process the queue (Peel away leaves)
        while (!queue.isEmpty()) {
            int node = queue.poll();
            inCycle[node] = false; // Node was peeled away, so it's not in the cycle
            
            for (int neighbor : adj.get(node)) {
                degree[neighbor]--; // Remove connection
                
                // If the neighbor becomes a leaf, add it to the queue
                if (degree[neighbor] == 1) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // 6. Find the last edge where both vertices are part of the cycle
        for (int i = n - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            if (inCycle[u] && inCycle[v]) {
                return edges[i];
            }
        }
        
        return new int[0];
    }
}