class Solution:
    def findLHS(self, nums: List[int]) -> int:
        mp = dict()
        for v in nums:
            mp[v] = mp.get(v, 0) + 1
        ans = 0
        for v in nums:
            if v + 1 in mp:
                ans = max(mp[v] + mp[v + 1], ans)
        return ans
