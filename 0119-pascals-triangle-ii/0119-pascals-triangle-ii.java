class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>>dp=new ArrayList<>();
        
        for(int i=0;i<=rowIndex;i++){
            List<Integer>row=new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(dp.get(i-1).get(j-1)+dp.get(i-1).get(j));
            }
            if(i>0){
                row.add(1);

            }
            dp.add(row);

        }
        return dp.get(rowIndex);

    }
}