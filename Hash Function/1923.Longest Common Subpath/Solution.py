class Solution:
    def longestCommonSubpath(self, n: int, paths: List[List[int]]) -> int:
        def check(k):
            cnt = defaultdict(int)
            for s in paths:
                vis = set()
                l = r = h1 = h2 = 0
                while r < len(s):
                    h1 = (h1 * base1 + s[r]) % M
                    h2 = (h2 * base2 + s[r]) % M
                    if r - l + 1 >= k:
                        if (h1, h2) not in vis:
                            cnt[(h1, h2)] += 1
                            vis.add((h1, h2))
                        h1 -= (s[l] * p1[k - 1])
                        h2 -= (s[l] * p2[k - 1])
                        l += 1
                    r += 1
            return max(cnt.values()) == len(paths)


        base1, base2, M = 131, 131313, int(1e9 + 7)
        m = 100010
        p1, p2 = [1] * m, [1] * m
        for i in range(1, m):
            p1[i] = p1[i - 1] * base1 % M
            p2[i] = p2[i - 1] * base2 % M
        l, r = 0, min([len(s) for s in paths])

        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return l
