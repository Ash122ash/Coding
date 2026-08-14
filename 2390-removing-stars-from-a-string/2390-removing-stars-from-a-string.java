class Solution {
    public String removeStars(String s) {
        Stack<Character> a= new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*'){
                a.pop();
            }
            else{
            a.push(s.charAt(i));}}

         StringBuilder ans = new StringBuilder();

        for (char c : a) {
            ans.append(c);
        }

        return ans.toString();
    }
    }