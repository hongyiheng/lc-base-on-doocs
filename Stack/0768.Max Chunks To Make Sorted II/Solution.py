class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        nums = arr[::]
        nums.sort()
        q = []
        ans = idx = 0
        for v in arr:
            if q:
                while q and q[0] == nums[idx]:
                    heapq.heappop(q)
                    idx += 1
                if not q:
                    ans += 1
            heapq.heappush(q, v)
        return ans + 1 if q else ans