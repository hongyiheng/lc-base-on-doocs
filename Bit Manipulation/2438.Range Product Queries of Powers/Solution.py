class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        powers = []
        for i in range(32):
            if n >> i & 1:
                powers.append(1 << i)
        mod = int(1e9) + 7
        pre = [0] * (len(powers) + 1)
        pre[0] = 1
        for i, v in enumerate(powers):
            pre[i + 1] = pre[i] * v
        ans = []
        for l, r in queries:
            ans.append(pre[r + 1] // pre[l] % mod)
        return ans