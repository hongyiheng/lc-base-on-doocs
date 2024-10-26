class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        f = 1
        nums = sorted(set(rewardValues))
        for v in nums:
            f |= (f & ((1 << v) - 1)) << v
        return f.bit_length() - 1
