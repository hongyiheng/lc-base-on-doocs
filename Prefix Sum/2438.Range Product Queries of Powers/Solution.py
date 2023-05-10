class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        m = int(1e9 + 7)
        q = []
        for i in range(30, -1, -1):
            if 1 << i <= n:
                n -= 1 << i
                q.append(1 << i)
        q = q[::-1]
        k = len(q)
        pre = [1] * (k + 1)
        for i in range(k):
            pre[i + 1] = pre[i] * q[i]
        ans = []
        for l, r in queries:
            ans.append(pre[r + 1] // pre[l] % m)
        return ans
