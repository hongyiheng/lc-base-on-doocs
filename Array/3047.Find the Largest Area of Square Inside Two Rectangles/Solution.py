class Solution:
    def largestSquareArea(self, bottomLeft: List[List[int]], topRight: List[List[int]]) -> int:
        n = len(bottomLeft)
        ans = 0
        for i in range(n):
            x1 = [bottomLeft[i][0], topRight[i][0]]
            y1 = [bottomLeft[i][1], topRight[i][1]]
            for j in range(i + 1, n):
                x2 = [bottomLeft[j][0], topRight[j][0]]
                y2 = [bottomLeft[j][1], topRight[j][1]]
                if x2[1] <= x1[0] or x2[0] >= x1[1]:
                    continue
                if y2[1] <= y1[0] or y2[0] >= y1[1]:
                    continue
                x, y = sorted(x1 + x2), sorted(y1 + y2)
                ans = max(ans, min(x[2] - x[1], y[2] - y[1]))
        return ans * ans
