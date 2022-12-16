class Solution:
    def minElements(self, nums: List[int], limit: int, goal: int) -> int:
        s = sum(nums)
        t = abs(goal - s)
        return (t + limit - 1) // limit
