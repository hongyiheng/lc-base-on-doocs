class Solution:
    def countRectangles(self, rectangles: List[List[int]], points: List[List[int]]) -> List[int]:
        H = 101
        h_group = [list() for _ in range(H)]
        for x, y in rectangles:
            h_group[y].append(x)
        # On(logn)
        for v in h_group:
            v.sort()
        ans = list()
        # On * On(logn)
        for x, y in points:
            s = 0
            for j in range(y, H):
                xs = h_group[j]
                if not xs:
                    continue
                l, r = 0, len(xs) - 1
                while l < r:
                    mid = (l + r) >> 1
                    if xs[mid] < x:
                        l = mid + 1
                    else:
                        r = mid
                s += len(xs) - l if xs[l] >= x else 0
            ans.append(s)
        return ans
