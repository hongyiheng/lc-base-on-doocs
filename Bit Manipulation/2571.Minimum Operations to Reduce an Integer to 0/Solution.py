class Solution:
    def minOperations(self, n: int) -> int:
        M = 20
        q = [False] * M
        for i in range(M):
            if n >> i & 1:
                q[i] = True
        ans = l = 0
        while l < M:
            if not q[l]:
                l += 1
                continue
            r = l
            while r < M and q[r + 1]:
                r += 1
            if r > l:
                q[r + 1] = True
            ans += 1
            l = r + 1
        return ans