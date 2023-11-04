class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        ans = mask = 0
        for i in range(30, -1, -1):
            mask |= 1 << i
            new_ans = ans | 1 << i
            vis = set()
            for v in nums:
                v &= mask
                if new_ans ^ v in vis:
                    ans = new_ans
                    break
                vis.add(v)
        return ans