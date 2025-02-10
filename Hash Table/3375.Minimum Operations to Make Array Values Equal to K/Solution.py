class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        s = set()
        for v in nums:
            if v > k:
                s.add(v)
            elif v < k:
                return -1
        return len(s)
