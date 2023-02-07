class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        arr = [[a, b] for a, b in zip(nums1, nums2)]
        arr.sort(key=lambda x: -x[1])
        q = [v[0] for v in arr[:k]]
        heapq.heapify(q)
        s = sum(q)
        ans = s * arr[k - 1][1]
        for i in range(k, len(nums1)):
            v = arr[i][0]
            if q and v > q[0]:
                heapq.heappush(q, v)
                s -= heapq.heappop(q)
                s += v
                ans = max(ans, s * arr[i][1])
        return ans