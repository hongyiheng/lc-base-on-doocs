class Solution:
    def maxGoodNumber(self, nums: List[int]) -> int:
        ans = 0
        for i in range(3):
            for j in range(3):
                for k in range(3):
                    if i != j and i != k and j != k:
                        v = (nums[i] << (nums[j].bit_length() + nums[k].bit_length())) + (
                                    nums[j] << nums[k].bit_length()) + nums[k]
                        ans = max(ans, v)
        return ans



