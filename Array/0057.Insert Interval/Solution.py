class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = []
        idx, n = 0, len(intervals)
        while idx < n and newInterval[0] > intervals[idx][1]:
            ans.append(intervals[idx])
            idx += 1
        left, right = newInterval[0], newInterval[1]
        if idx < n:
            while idx < n and right >= intervals[idx][0]:
                left = min(intervals[idx][0], left)
                right = max(intervals[idx][1], right)
                idx += 1
        ans.append([left, right])
        while idx < n:
            ans.append(intervals[idx])
            idx += 1
        return ans