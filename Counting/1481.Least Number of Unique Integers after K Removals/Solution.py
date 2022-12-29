class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        mp = dict()
        for v in arr:
            mp[v] = mp.get(v, 0) + 1
        nums = [mp[k] for k in mp.keys()]
        nums.sort()
        ans = len(nums)
        for v in nums:
            if k < v:
                break
            k -= v
            ans -= 1
        return ans