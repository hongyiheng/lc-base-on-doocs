class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        return [v for v in nums if v < pivot] + [v for v in nums if v == pivot] + [v for v in nums if v > pivot]