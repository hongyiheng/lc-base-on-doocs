class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], k: int) -> int:
        cnt = Counter(v // k for v in nums1 if not v % k)
        if not cnt:
            return 0
        ans = 0
        mx = max(cnt)
        cnt2 = Counter(nums2)
        for x in cnt2.keys():
            for y in range(x, mx + 1, x):
                ans += cnt[y] * cnt2[x]
        return ans
