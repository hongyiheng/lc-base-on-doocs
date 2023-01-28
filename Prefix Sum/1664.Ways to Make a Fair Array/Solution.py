class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        n = len(nums)
        s = [[0] * 2 for _ in range(n + 1)]
        for i in range(1, n + 1):
            s[i][0] = s[i - 1][0]
            s[i][1] = s[i - 1][1]
            if (i - 1) % 2:
                s[i][1] += nums[i - 1]
            else:
                s[i][0] += nums[i - 1]
        ans = 0
        for i in range(n):
            odd = even = 0
            if i % 2:
                odd = s[n][0] - s[i + 1][0] + s[i + 1][1] - nums[i]
                even = s[n][1] - s[i + 1][1] + s[i + 1][0]
            else:
                even = s[n][1] - s[i + 1][1] + s[i + 1][0] - nums[i]
                odd = s[n][0] - s[i + 1][0] + s[i + 1][1]
            if odd == even:
                ans += 1
        return ans