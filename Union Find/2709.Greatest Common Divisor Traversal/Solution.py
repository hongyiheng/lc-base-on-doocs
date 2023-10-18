class Solution:
    def canTraverseAllPairs(self, nums: List[int]) -> bool:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            p[find(a)] = find(b)

        if len(nums) == 1:
            return True
        p = [i for i in range(100010)]
        s = set()
        for i, v in enumerate(nums):
            if v == 1:
                return False
            if v in s:
                continue
            s.add(v)
            x = 2
            while x * x <= v:
                if v % x == 0:
                    union(nums[i], x)
                    while v % x == 0:
                        v //= x
                x += 1
            if 1 < v != nums[i]:
                union(nums[i], v)
        root = find(nums[0])
        for v in nums:
            if find(v) != root:
                return False
        return True