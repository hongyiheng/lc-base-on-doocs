class Solution:
    def numberOfChild(self, n: int, k: int) -> int:
        d = True
        ans = 0
        while k:
            if ans == 0:
                d = True
            elif ans == n - 1:
                d = False
            v = min(k, n - 1)
            if d:
                ans += v
            else:
                ans -= v
            k -= v
        return ans