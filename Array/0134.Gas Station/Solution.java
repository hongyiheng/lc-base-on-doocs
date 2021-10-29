class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int lack = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                lack += -cur;
                cur = 0;
                start = i + 1;
            }
        }
        return cur >= lack ? start : -1;
    }
}