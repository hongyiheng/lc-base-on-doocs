class Solution:
    def duplicateNumbersXOR(self, nums: List[int]) -> int:
        cnt = ans = 0
        for v in nums:
            if cnt >> v & 1 != 0:
                ans ^= v
            cnt |= 1 << v
        return ans