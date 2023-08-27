class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x:x[0])
        i, n = 0, len(intervals)
        ans = []
        while i < n:
            l, r = intervals[i]
            while i + 1 < n and intervals[i + 1][0] <= r:
                i += 1
                r = max(r, intervals[i][1])
            ans.append([l, r])
            i += 1
        return ans
