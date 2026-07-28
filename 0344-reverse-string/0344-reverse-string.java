class Solution {
    public void reverseString(char[] s) {
        int n= s.length;
        char temp[]=new char[n];
        for(int i=0;i<n;i++){
            temp[i]=s[n-i-1];
        }       
        for(int j=0;j<n;j++){
            s[j]=temp[j];
        }
    }
}