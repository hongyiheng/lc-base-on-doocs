class Solution:
    def anagramMappings(self, nums1: List[int], nums2: List[int]) -> List[int]:
        mp = defaultdict(list)
        for i, v in enumerate(nums2):
            mp[v].append(i)
        ans = [0] * len(nums1)
        for i, v in enumerate(nums1):
            ans[i] = mp[v].pop()
        return ans
