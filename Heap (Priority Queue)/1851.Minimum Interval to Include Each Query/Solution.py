class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        qs = [[v, i] for i, v in enumerate(queries)]
        qs.sort()
        intervals.sort()
        idx, n = 0, len(intervals)
        ans = [-1] * len(queries)
        ins = []
        for v, i in qs:
            while idx < n and intervals[idx][0] <= v:
                l, r = intervals[idx]
                heapq.heappush(ins, [r - l + 1, r])
                idx += 1
            while ins and ins[0][1] < v:
                heapq.heappop(ins)
            if ins:
                ans[i] = ins[0][0]
        return ans