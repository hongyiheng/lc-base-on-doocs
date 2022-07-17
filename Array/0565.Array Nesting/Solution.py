class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        ans, n = 0, len(nums)
        used = [False] * n
        for i in range(n):
            cur, cnt = nums[i], 0
            while not used[cur]:
                cnt += 1
                used[cur] = True
                cur = nums[cur]
            ans = max(ans, cnt)
        return ans