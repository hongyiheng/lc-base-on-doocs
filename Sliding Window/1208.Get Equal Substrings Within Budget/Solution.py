class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        n = len(s)
        cost = [0] * n
        for i in range(n):
            cost[i] = abs(ord(t[i]) - ord(s[i]))
        l = r = cur = ans = 0
        while r < n:
            cur += cost[r]
            while cur > maxCost:
                cur -= cost[l]
                l += 1
            ans = max(ans, r - l + 1)
            r += 1
        return ans