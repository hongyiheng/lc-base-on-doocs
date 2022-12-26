class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        mp = dict()
        mp[0] = -1
        cur = ans = 0
        for i, v in enumerate(nums):
            if v == 1:
                cur += 1
            else:
                cur -= 1
            if cur in mp:
                ans = max(ans, i - mp[cur])
            else:
                mp[cur] = i
        return ans