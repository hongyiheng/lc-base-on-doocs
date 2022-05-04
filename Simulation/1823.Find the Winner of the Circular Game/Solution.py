class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        nums = [0] + [1] * n
        idx, step, left = 1, 0, n
        while left > 1:
            if nums[idx] == 1:
                step += 1
            if step == k:
                nums[idx] = 0
                step = 0
                left -= 1
            idx = 1 if idx == n else idx + 1
        for i, v in enumerate(nums):
            if v == 1:
                return i
        return 1