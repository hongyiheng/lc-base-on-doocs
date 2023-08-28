class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = []
        i, n = 0, len(intervals)
        while i < n and intervals[i][1] < newInterval[0]:
            ans.append(intervals[i])
            i += 1
        l, r = newInterval
        while i < n and intervals[i][0] <= r and intervals[i][1] >= l:
            l = min(l, intervals[i][0])
            r = max(r, intervals[i][1])
            i += 1
        ans.append([l, r])
        while i < n:
            ans.append(intervals[i])
            i += 1
        return ans

