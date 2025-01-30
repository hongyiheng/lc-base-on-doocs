class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        cnt = [0] * 1010
        for v in nums1:
            cnt[v] += 1
        ans = []
        for v in nums2:
            if cnt[v]:
                ans.append(v)
                cnt[v] -= 1
        return ans