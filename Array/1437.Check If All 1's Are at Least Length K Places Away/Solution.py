class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        s = k
        for v in nums:
            if v == 1 and s < k:
                return False
            elif not v:
                s += 1
            else:
                s = 0
        return True
