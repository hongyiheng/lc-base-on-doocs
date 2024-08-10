class Solution:
    def leftmostBuildingQueries(self, heights: List[int], queries: List[List[int]]) -> List[int]:
        n = len(queries)
        ans = [-1] * n
        qs = []
        for i, v in enumerate(queries):
            v.sort()
            j, k = v
            if j == k:
                ans[i] = j
            elif heights[j] < heights[k]:
                ans[i] = k
            elif heights[j] >= heights[k]:
                qs.append([k, heights[j] + 1, i])

        qs.sort(key = lambda x: (-x[0], -x[1]))
        hs = []
        for i, h in enumerate(heights):
            while qs and qs[-1][0] <= i:
                heapq.heappush(hs, (qs[-1][1], qs[-1][2]))
                qs.pop()
            while hs and hs[0][0] <= h:
                ans[heapq.heappop(hs)[1]] = i
        return ans
