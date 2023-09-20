class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        ans = []
        for v in nums:
            t = []
            while v:
                t.append(v % 10)
                v //= 10
            ans.extend(t[::-1])
        return ans