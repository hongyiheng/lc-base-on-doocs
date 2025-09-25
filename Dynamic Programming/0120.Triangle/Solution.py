class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for i, row in enumerate(triangle):
            if not i:
                continue
            last = triangle[i - 1]
            for j in range(len(row)):
                mi = last[max(j - 1, 0)]
                mi = min(mi, last[min(j, len(last) - 1)])
                row[j] += mi
        return min(triangle[-1])
