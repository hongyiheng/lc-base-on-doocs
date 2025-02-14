class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        def check(x):
            last = position[0]
            ans = 1
            for v in position:
                if v - last >= x:
                    ans += 1
                    last = v
            return ans >= m

        position.sort()
        l, r = 1, position[-1]
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r