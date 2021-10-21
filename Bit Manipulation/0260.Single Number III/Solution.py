class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        two_num_bit = 0
        for num in nums:
            two_num_bit ^= num
        low_bit = two_num_bit & -two_num_bit
        ans = [0, 0]
        for num in nums:
            if num & low_bit == 0:
                ans[0] ^= num
            else:
                ans[1] ^= num
        return ans
