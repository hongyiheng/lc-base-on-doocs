class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        cnt = [0] * 501
        t = len(nums) // 2
        for v in nums:
            cnt[v] += 1
            if cnt[v] >= 2:
                cnt[v] -= 2
                t -= 1
        return t == 0