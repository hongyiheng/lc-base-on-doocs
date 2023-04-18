class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        def get_rate(p1, p2):
            return 0x3f3f3f3f if p2[0] - p1[0] == 0 else (p2[1] - p1[1]) / (p2[0] - p1[0])

        ans, n = 1, len(points)
        for i in range(n):
            for j in range(i + 1, n):
                rate = get_rate(points[i], points[j])
                cnt = 2
                for k in range(n):
                    if k == i or k == j:
                        continue
                    if get_rate(points[i], points[k]) == rate:
                        cnt += 1
                ans = max(ans, cnt)
        return ans
