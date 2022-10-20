class Solution:
    def countDistinctIntegers(self, nums: List[int]) -> int:
        s = set()
        for v in nums:
            s.add(v)
            s.add(int(str(v)[::-1]))
        return len(s)
