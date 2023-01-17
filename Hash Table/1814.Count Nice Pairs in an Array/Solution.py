class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        mp = dict()
        for v in nums:
            t = v - int(str(v)[::-1])
            mp[t] = mp.get(t, 0) + 1
        ans = 0
        for v in mp.values():
            ans += v * (v - 1) // 2
        return ans % (10 ** 9 + 7)
