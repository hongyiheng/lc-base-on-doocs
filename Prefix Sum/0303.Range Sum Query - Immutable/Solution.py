class NumArray:

    def __init__(self, nums: List[int]):
        n = len(nums)
        self.pre = [0] * (n + 1)
        for i, v in enumerate(nums):
            self.pre[i + 1] = self.pre[i] + nums[i]

    def sumRange(self, left: int, right: int) -> int:
        return self.pre[right + 1] - self.pre[left]



# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)