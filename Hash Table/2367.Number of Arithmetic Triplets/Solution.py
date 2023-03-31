class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        s = {v for v in nums}
        ans = 0
        for v in nums:
            if v + diff in s and v + 2 * diff in s:
                ans += 1
        return ans
