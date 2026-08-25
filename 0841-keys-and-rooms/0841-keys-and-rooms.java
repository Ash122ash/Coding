class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        Queue<Integer>q=new LinkedList<>();
        boolean[]b=new boolean[n];
        b[0]=true;
        q.offer(0);
        while(!q.isEmpty()){
            int h=q.poll();
            for(int neighbour:rooms.get(h)){
                if(!b[neighbour]){
                    b[neighbour]=true;
                    q.offer(neighbour);
                }
            }

        }
        for(int i=0;i<n;i++){
            if(b[i]==false){
                return false;
            }
            
        }
        return true;
        
    }
}