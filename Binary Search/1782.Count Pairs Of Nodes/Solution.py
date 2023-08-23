class Solution:
    def countPairs(self, n: int, edges: List[List[int]], queries: List[int]) -> List[int]:
        cnt = [0] * (n + 1)
        g = defaultdict(int)
        for u, v in edges:
            cnt[u] += 1
            cnt[v] += 1
            g[(min(u, v), max(u, v))] += 1
        s = sorted(cnt)
        ans = [0] * len(queries)
        for i, t in enumerate(queries):
            for j in range(1, len(s)):
                l, r = j + 1, len(s)
                while l < r:
                    mid = (l + r) >> 1
                    if s[mid] <= t - s[j]:
                        l = mid + 1
                    else:
                        r = mid
                ans[i] += n - l + 1
            for (a, b), v in g.items():
                if cnt[a] + cnt[b] > t and cnt[a] + cnt[b] - v <= t:
                    ans[i] -= 1
        return ans

