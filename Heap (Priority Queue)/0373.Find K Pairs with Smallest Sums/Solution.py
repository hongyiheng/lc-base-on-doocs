class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        ans = []
        n, m = len(nums1), len(nums2)
        q = [(nums1[i] + nums2[0], i, 0) for i in range(min(k, n))]
        while q and k > 0:
            cur = heappop(q)
            i, j = cur[1], cur[2]
            ans.append([nums1[i], nums2[j]])
            if j + 1 < m:
                heappush(q, (nums1[i] + nums2[j + 1], i , j + 1))
            k -= 1
        return ans