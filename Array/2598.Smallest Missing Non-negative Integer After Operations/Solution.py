class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        cnt = [0] * value
        for v in nums:
            cnt[v % value] += 1
        ans = 0
        while cnt[0]:
            for i, v in enumerate(cnt):
                if not v:
                    return ans
                ans += 1
                cnt[i] -= 1
        return ans
