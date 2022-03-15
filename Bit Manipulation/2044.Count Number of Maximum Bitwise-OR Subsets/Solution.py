class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        n, mx, ans = len(nums), 0, 0
        mask = 1 << n
        for s in range(mask):
            cur = 0
            for i, v in enumerate(nums):
                if (s >> i) & 1 == 1:
                    cur |= v
            if cur > mx:
                mx = cur
                ans = 1
            elif cur == mx:
                ans += 1
        return ans
