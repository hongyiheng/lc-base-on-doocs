class Solution:
    def rampartDefensiveLine(self, rampart: List[List[int]]) -> int:
        def check(x):
            last = -inf
            n = len(rampart)
            for i in range(n - 1):
                l, r = rampart[i]
                if l - last + rampart[i + 1][0] - r < x:
                    return False
                last = max(r, r + x - l + last)
            return True

        l, r = 0, rampart[-1][0] - rampart[0][1]
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r