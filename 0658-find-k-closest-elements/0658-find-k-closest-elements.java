class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         List<Integer>c=new ArrayList<>();
         int left=0;
         for(int right=k;right<arr.length;right++){
           if(x-arr[left]>arr[right]-x){
            left++;
           }
           else{
            break;
           }

         }
    
    for(int i=left;i<left+k;i++){
        c.add(arr[i]);
    }
    return c;
}}