class Solution:
    def minimumEffort(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda x:-(x[1] - x[0]))
        ans = left = 0
        for a, m in tasks:
            if left >= m:
                left -= a
            else:
                ans += m - left
                left = m - a
        return ans
