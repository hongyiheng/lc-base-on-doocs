class Solution:

    def __init__(self, nums: List[int]):
        self.nums = nums

    def pick(self, target: int) -> int:
        cnt, ans = 0, 0
        for i, v in enumerate(self.nums):
            if v == target:
                cnt += 1
                if randrange(cnt) == 0:
                    ans = i
        return ans



# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)