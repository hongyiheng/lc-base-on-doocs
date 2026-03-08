class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        n = len(nums)
        for v in range(1 << n):
            s = ""
            for i in range(n):
                if v >> i & 1:
                    s += '1'
                else:
                    s += '0'
            if s not in nums:
                return s
