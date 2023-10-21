class Solution:
    def maximumXOR(self, nums: List[int]) -> int:
        ans = 0
        for i in range(32):
            for v in nums:
                if v >> i & 1:
                    ans |= 1 << i
                    break
        return ans
