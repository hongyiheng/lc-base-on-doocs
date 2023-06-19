class Solution:
    def maximumOr(self, nums: List[int], k: int) -> int:
        cnt = [0] * 50
        for v in nums:
            for i in range(31):
                if v >> i & 1:
                    cnt[i] += 1
        ans = nums[0]
        for v in nums:
            for i in range(31):
                if v >> i & 1:
                    cnt[i] -= 1
                    cnt[i + k] += 1
            cur = 0
            for i in range(50):
                if cnt[i]:
                    cur += 1 << i
            ans = max(ans, cur)
            for i in range(31):
                if v >> i & 1:
                    cnt[i] += 1
                    cnt[i + k] -= 1
        return ans
