class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
        vis = set()
        i, n = 0, len(nums)
        while i + 1 < n:
            s = nums[i] + nums[i + 1]
            if s in vis:
                return True
            vis.add(s)
            i += 1
        return False
