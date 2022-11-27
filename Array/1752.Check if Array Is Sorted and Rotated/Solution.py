class Solution:
    def check(self, nums: List[int]) -> bool:
        n = len(nums)
        turn = False
        for i in range(1, n):
            if nums[i] < nums[i - 1]:
                if turn:
                    return False
                turn = True
        return nums[n - 1] <= nums[0] or not turn
