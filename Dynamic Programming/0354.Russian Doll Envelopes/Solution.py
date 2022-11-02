class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        def cmp(a, b):
            if a[0] != b[0]:
                return a[0] - b[0]
            return b[1] - a[1]

        envelopes.sort(key=cmp_to_key(cmp))
        nums = [v[1] for v in envelopes]
        ans, n = 0, len(nums)
        dp = [0] * n
        for i in range(n):
            l, r = 0, ans
            while l < r:
                mid = (l + r) >> 1
                if dp[mid] < nums[i]:
                    l = mid + 1
                else:
                    r = mid
            dp[l] = nums[i]
            if l == ans:
                ans += 1
        return ans
