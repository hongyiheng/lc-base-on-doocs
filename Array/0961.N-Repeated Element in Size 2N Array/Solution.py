class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        n = len(nums) // 2
        cnt = Counter(nums)
        for k, v in cnt.items():
            if v == n:
                return k
        return -1