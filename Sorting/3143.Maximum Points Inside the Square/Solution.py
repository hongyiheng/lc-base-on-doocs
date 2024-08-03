class Solution:
    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        def f(i, d):
            ans = 0
            while i < len(points):
                x, y, j = q[i]
                if abs(x) > d or abs(y) > d:
                    return ans
                if s[j] in vis:
                    return -1
                vis.add(s[j])
                ans += 1
                i += 1
            return ans

        q = [(v[0], v[1], i) for i, v in enumerate(points)]
        q.sort(key=lambda x: max(abs(x[0]), abs(x[1])))
        i = 0
        vis = set()
        while i < len(points):
            x, y, j = q[i]
            cnt = f(i, max(abs(x), abs(y)))
            if cnt == -1:
                return i
            i += cnt
        return i