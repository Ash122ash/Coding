import java.util.*;

class Solution {
    public List<Long> mergeAdjacent(int[] nums) {

        List<Long> ans = new ArrayList<>();

        for (int num : nums) {
            ans.add((long) num);

            int i = ans.size() - 1;

            while (i > 0 && ans.get(i).equals(ans.get(i - 1))) {

                long sum = ans.get(i) + ans.get(i - 1);

                ans.remove(i);
                ans.set(i - 1, sum);

                i--;
            }
        }

        return ans;
    }
}