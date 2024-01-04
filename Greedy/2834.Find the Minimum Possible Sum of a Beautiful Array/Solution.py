class Solution:
    def minimumPossibleSum(self, n: int, target: int) -> int:
        cnt = min(n, target // 2)
        ans = (1 + cnt) * cnt / 2
        if cnt < n:
            ans += (target + target + n - cnt - 1) * (n - cnt) / 2
        return int(ans % int(1e9 + 7))