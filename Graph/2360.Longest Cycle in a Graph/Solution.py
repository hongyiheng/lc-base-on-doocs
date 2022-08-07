class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        n = len(edges)
        time = [0] * n
        ans, cur = -1, 1
        for i in range(n):
            if time[i]:
                continue
            start_time, x = cur, i
            while x != -1:
                if time[x]:
                    if time[x] >= start_time:
                        ans = max(ans, cur - time[x])
                    break
                time[x] = cur
                cur += 1
                x = edges[x]
        return ans