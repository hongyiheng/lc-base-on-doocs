class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        cur, lack, start = 0, 0, 0
        for i in range(len(gas)):
            cur += gas[i] - cost[i]
            if cur < 0:
                lack += -cur
                cur = 0
                start = i + 1
        return start if cur >= lack else -1