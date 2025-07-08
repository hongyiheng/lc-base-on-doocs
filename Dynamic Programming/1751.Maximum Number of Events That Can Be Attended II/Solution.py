class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        @cache
        def dfs(i, k):
            if i >= n or k == 0:
                return 0
            ans1 = dfs(i + 1, k)
            j = i + 1
            while j < n and events[j][0] <= events[i][1]:
                j += 1
            ans2 = events[i][2] + dfs(j, k - 1)
            return max(ans1, ans2)

        events.sort()
        n = len(events)
        return dfs(0, k)