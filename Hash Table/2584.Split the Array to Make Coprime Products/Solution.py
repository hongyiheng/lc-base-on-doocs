class Solution:
    def findValidSplit(self, nums: List[int]) -> int:
        def f(x, i):
            if x not in left:
                left[x] = i
            else:
                right[left[x]] = i

        left = dict()
        right = [0] * len(nums)

        for i, v in enumerate(nums):
            d = 2
            while d * d <= v:
                if not v % d:
                    f(d, i)
                    while not v % d:
                        v //= d
                d += 1
            if v > 1:
                f(v, i)

        mr = 0
        for l, r in enumerate(right):
            if l > mr:
                return mr
            mr = max(mr, r)
        return -1