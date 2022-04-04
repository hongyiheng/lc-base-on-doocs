class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        mp = dict()
        for v in nums1:
            mp[v] = mp.get(v, 0) + 1
        ans = []
        for v in nums2:
            cnt = mp.get(v, 0)
            if cnt > 0:
                ans.append(v)
                cnt -= 1
                mp[v] = cnt
        return ans
