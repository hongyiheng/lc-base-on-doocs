class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        ans = 0
        mp = dict()
        for i, v in enumerate(nums):
            d = i - v
            ans += i - mp.get(d, 0)
            mp[d] = mp.get(d, 0) + 1
        return ans
