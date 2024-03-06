class Solution:
    def findKOr(self, nums: List[int], k: int) -> int:
        cnt = [0] * 31
        for i in range(31):
            for v in nums:
                if v >> i & 1:
                    cnt[i] += 1
        ans = 0
        for i in range(31):
            if cnt[i] >= k:
                ans |= (1 << i)
        return ans