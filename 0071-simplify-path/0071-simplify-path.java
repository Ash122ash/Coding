class Solution {
    public String simplifyPath(String path) {
        Stack<String> a = new Stack<>();

        String[] arr = path.split("/");

        for (String s : arr) {

            if (s.equals("") || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (!a.isEmpty()) {
                    a.pop();
                }
            } 
            else {
                a.push(s);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String s : a) {
            ans.append("/").append(s);
        }

        if (ans.length() == 0) {
            return "/";
        }

        return ans.toString();
    }
}