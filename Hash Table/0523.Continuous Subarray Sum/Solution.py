class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        last = pre = 0
        s = set()
        for v in nums:
            last = pre
            pre = (pre + v) % k
            if pre in s:
                return True
            s.add(last)
        return False