class Solution:
    def minChanges(self, nums: List[int], k: int) -> int:
        n, m = len(nums), 1 << 10
        f = [[0x3f3f3f3f] * m for _ in range(k)]
        g = [0x3f3f3f3f] * k
        for i in range(k):
            cnt = dict()
            s = 0
            for j in range(i, n, k):
                cnt[nums[j]] = cnt.get(nums[j], 0) + 1
                s += 1
            if i == 0:
                for x in range(m):
                    f[0][x] = s - cnt.get(x, 0)
                    g[0] = min(g[0], f[0][x])
            else:
                for x in range(m):
                    f[i][x] = g[i - 1] + s
                    for v in cnt.keys():
                        f[i][x] = min(f[i][x], f[i - 1][x ^ v] + s - cnt.get(v))
                        g[i] = min(g[i], f[i][x])
        return f[k - 1][0]