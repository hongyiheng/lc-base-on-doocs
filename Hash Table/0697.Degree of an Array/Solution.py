class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        mp = defaultdict(int)
        for v in nums:
            mp[v] += 1
        mx = 0
        s = set()
        for k in mp.keys():
            if mp[k] > mx:
                s.clear()
                mx = mp[k]
            if mp[k] == mx:
                s.add(k)
        mp = dict()
        for i, v in enumerate(nums):
            if v in s:
                l, r = mp.get(v, [0x3f3f3f, 0])
                l = min(l, i)
                r = max(r, i)
                mp[v] = [l, r]
        ans = float('inf')
        for l, r in mp.values():
            ans = min(r - l + 1, ans)
        return ans