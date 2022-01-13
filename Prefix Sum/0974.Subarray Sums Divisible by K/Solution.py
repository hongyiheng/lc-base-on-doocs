class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        mp = {0: 1}
        s, ans = 0, 0
        for v in nums:
            s += v
            same = mp.get(s % k, 0)
            ans += same
            mp[s % k] = same + 1
        return ans