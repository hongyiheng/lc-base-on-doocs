class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        def check(t):
            q = [0] * (len(nums) + 1)
            for l, r, v in queries[:t]:
                q[l] += v
                q[r + 1] -= v
            d = 0
            for i, v in enumerate(nums):
                d += q[i]
                if v > d:
                    return False
            return True

        l, r = 0, len(queries)
        while l < r:
            mid = (l + r) >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r if check(r) else -1
