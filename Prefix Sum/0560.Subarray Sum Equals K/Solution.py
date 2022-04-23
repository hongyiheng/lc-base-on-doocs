class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n, cur, ans = len(nums), 0, 0
        mp = dict()
        mp[0] = 1
        for v in nums:
            cur += v
            if (cur - k) in mp:
                ans += mp[cur - k]
            mp[cur] = mp.get(cur, 0) + 1
        return ans