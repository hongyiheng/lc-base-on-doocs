class Solution:
    def canSortArray(self, nums: List[int]) -> bool:
        def bit_cnt(x):
            ans = 0
            while x:
                x -= x & - x
                ans += 1
            return ans

        mx = last_mx = last_bit = 0
        for v in nums:
            cur_bit = bit_cnt(v)
            if v < last_mx or (v < mx and last_bit != cur_bit):
                return False
            if cur_bit != last_bit:
                last_mx = mx
            mx = max(mx, v)
            last_bit = cur_bit
        return True