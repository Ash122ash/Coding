class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // 1. Change 'a' to store int[] arrays so it holds BOTH neighbor and weight
        List<List<int[]>> a = new ArrayList<>();
        int[] b = new int[n+1];  // 'b' will now store the minimum TOTAL time to reach each node
        
        // 2. Initialize 'b' with infinity, except the start node which takes 0 time
        Arrays.fill(b, Integer.MAX_VALUE);
        b[k] = 0; 
        
        for(int i=0; i<=n; i++){
            a.add(new ArrayList<>());
        }
        
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            // Store both destination and weight together
            a.get(u).add(new int[]{v, w});
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        
        while(!q.isEmpty()){
            int c = q.poll();
            
            // 3. Extract both neighbor and weight from the list
            for(int[] info : a.get(c)){
                int neighbour = info[0];
                int weight = info[1];
                
                // 4. If current path is faster than the previously recorded time, update and queue it
                if(b[c] + weight < b[neighbour]){
                    b[neighbour] = b[c] + weight;
                    q.offer(neighbour); 
                }
            }
        }
        
        // 5. Find the maximum time in array 'b'
        int count = 0;
        for(int i = 1; i <= n; i++){
            // If any node is still MAX_VALUE, it was unreachable
            if(b[i] == Integer.MAX_VALUE){
                return -1;
            }
            count = Math.max(count, b[i]);
        }
        
        return count;
    }
}