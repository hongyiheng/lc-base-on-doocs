class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mp = dict()
        for i, v in enumerate(nums):
            if v in mp:
                return [mp[v], i]
            mp[target - v] = i
        return []