class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph=new ArrayList<>();
        int[]n=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]edge:prerequisites){
            int course=edge[0];
            int prerequisite=edge[1];
            graph.get(prerequisite).add(course);
            n[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (n[i] == 0) {
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[idx++] = curr;
            for (int neighbor : graph.get(curr)) {
                n[neighbor]--;
                
                if (n[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: If all courses were processed, return order; otherwise a cycle exists
        return (idx == numCourses) ? order : new int[0];
    }
}


   