class Solution:
    def rectangleArea(self, rectangles: List[List[int]]) -> int:
        def cmp(a, b):
            if a[0] != b[0]:
                return a[0] - b[0]
            return a[1] - b[1]

        xs = []
        for v in rectangles:
            xs.append(v[0])
            xs.append(v[2])
        xs.sort()
        ans = 0
        for i in range(1, len(xs)):
            left, right = xs[i - 1], xs[i]
            if right == left:
                continue
            ys = []
            for v in rectangles:
                if v[0] <= left and right <= v[2]:
                    ys.append([v[1], v[3]])
            ys.sort(key=cmp_to_key(cmp))
            h, d, t = 0, -1, -1
            for y in ys:
                if y[0] > t:
                    h += t - d
                    d, t = y[0], y[1]
                elif y[1] > t:
                    t = y[1]
            h += t - d
            ans += (right - left) * h
        return ans % int(1e9 + 7)