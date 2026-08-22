class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // [a, b] means b -> a (finish b before taking a)
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        // Step 2: Add all courses with 0 prerequisites (in-degree == 0) to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process the queue
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++; // Course successfully completed

            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                // If all prerequisites for neighbor are completed, enqueue it
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If completed courses equal total courses, no cycle exists
        return count == numCourses;
    }}