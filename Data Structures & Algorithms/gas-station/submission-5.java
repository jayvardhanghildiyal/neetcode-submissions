class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // checking if travelling the circuit is possible
        int gasSum = 0;
        int costSum = 0;

        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) {
            return -1;
        }
        int index = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];

            if (sum < 0) {
                sum = 0;
                index = i + 1;
            }
            
        }
        return index;
    }
}
