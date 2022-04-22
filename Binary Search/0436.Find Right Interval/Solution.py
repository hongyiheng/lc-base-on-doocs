class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        def hash(x):
            return x[0] * 13331 + x[1]

        n = len(intervals)
        ans = [-1] * n
        mp = dict()
        for i, v in enumerate(intervals):
            mp[hash(v)] = i
        intervals.sort(key=lambda x: x[0])
        for v in intervals:
            target = v[1]
            left, right = 0, n - 1
            while left < right:
                mid = (left + right) >> 1
                if intervals[mid][0] < target:
                    left = mid + 1
                else:
                    right = mid
            if intervals[left][0] >= target:
                ans[mp[hash(v)]] = mp[hash(intervals[left])]
        return ans
