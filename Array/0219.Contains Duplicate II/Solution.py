class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        f = dict()
        for i, v in enumerate(nums):
            if v in f and i - f[v] <= k:
                return True
            f[v] = i
        return False
        