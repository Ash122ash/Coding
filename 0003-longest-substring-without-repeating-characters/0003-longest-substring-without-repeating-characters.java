class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxlength=0;
        HashSet<Character> charSet=new HashSet<>();
        for(int right=0;right<s.length();right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;

    }
}