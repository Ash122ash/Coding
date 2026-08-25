class Solution {
    public int fib(int n) {
        int[]a=new int[n+1];
        if(n==0||n==1){
            return n;
        }
        if(a[n]!=0){
            return a[n];
        }
        a[n]=fib(n-1)+fib(n-2);
        return a[n];
    }
}