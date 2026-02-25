class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        cnt = Counter(nums)
        return [k for k, v in cnt.items() if v > len(nums) / 3]