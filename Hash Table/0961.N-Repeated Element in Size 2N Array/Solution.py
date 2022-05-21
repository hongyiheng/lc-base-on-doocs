class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        n = len(nums) // 2
        cnt = [0] * 10001
        for v in nums:
            cnt[v] += 1
            if cnt[v] == n:
                return v
        return -1