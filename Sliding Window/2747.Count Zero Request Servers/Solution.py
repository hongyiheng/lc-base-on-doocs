class Solution:
    def countServers(self, n: int, logs: List[List[int]], x: int, queries: List[int]) -> List[int]:
        ans = [0] * len(queries)
        q = [[i, v] for i, v in enumerate(queries)]
        q.sort(key=lambda k:k[1])
        logs.sort(key=lambda k:k[1])
        cnt = [0] * (n + 1)
        l = r = cur = 0
        for i, v in q:
            while r < len(logs) and logs[r][1] <= v:
                if not cnt[logs[r][0]]:
                    cur += 1
                cnt[logs[r][0]] += 1
                r += 1
            while l < len(logs) and logs[l][1] < v - x:
                cnt[logs[l][0]] -= 1
                if not cnt[logs[l][0]]:
                    cur -= 1
                l += 1
            ans[i] = n - cur
        return ans