class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        ans = list(s)
        n = len(s)
        for i in range(0, n, 2 * k):
            l, r = i, min(i + k - 1, n - 1)
            while l < r:
                ans[l], ans[r] = ans[r], ans[l]
                l += 1
                r -= 1
        return "".join(ans)
