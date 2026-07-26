class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> s = new ArrayList<>();
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int start = nums[i];

            while (i < n - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start == nums[i]) {
                s.add(String.valueOf(start));
            } else {
                s.add(start + "->" + nums[i]);
            }

            i++;
        }

        return s;
    }
}