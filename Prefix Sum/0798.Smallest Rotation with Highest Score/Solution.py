class Solution:
    def bestRotation(self, nums: List[int]) -> int:
        n = len(nums)
        cnt = [0] * n
        for i in range(n):
            cnt[(i + 1) % n] += 1
            cnt[(n + i + 1 - nums[i]) % n] -= 1
        mx, cur, ans = -1, 0, 0
        for i in range(n):
            cur += cnt[i]
            if mx < cur:
                mx = cur
                ans = i
        return ans