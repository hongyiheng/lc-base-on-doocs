class Solution:
    def numWays(self, s: str) -> int:
        cnt = 0
        for c in s:
            if c == '1':
                cnt += 1
        if cnt % 3:
            return 0
        n = len(s)
        mod = int(1e9 + 7)
        if cnt == 0:
            return (n - 1) * (n - 2) // 2 % mod
        t, cnt = cnt // 3, 0
        q = [0, 0]
        for c in s:
            if c == '1':
                cnt += 1
            else:
                if cnt == t:
                    q[0] += 1
                if cnt == 2 * t:
                    q[1] += 1
        return (q[0] + 1) * (q[1] + 1) % mod