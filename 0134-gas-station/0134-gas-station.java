
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGain = gas[i] - cost[i];
            totalTank += netGain;
            currentTank += netGain;

            // If fuel runs out, none of the stations from startIndex up to i can be the start
            if (currentTank < 0) {
                startIndex = i + 1;
                currentTank = 0;
            }
        }

        return totalTank >= 0 ? startIndex : -1;
    }
}