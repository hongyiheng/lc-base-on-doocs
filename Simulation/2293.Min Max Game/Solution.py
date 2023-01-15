class Solution:
    def minMaxGame(self, nums: List[int]) -> int:
        while len(nums) > 1:
            tmp = []
            flag = True
            for i in range(0, len(nums), 2):
                tmp.append(min(nums[i], nums[i + 1]) if flag else max(nums[i], nums[i + 1]))
                flag = not flag
            nums = tmp
        return nums[0]