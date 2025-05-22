class Solution:
    def maxRemoval(self, nums: List[int], queries: List[List[int]]) -> int:
        queries.sort()
        pq = []
        q = [0] * (len(nums) + 1)
        d = pos = 0
        for i, v in enumerate(nums):
            d += q[i]
            while pos < len(queries) and queries[pos][0] <= i:
                heapq.heappush(pq, -queries[pos][1])
                pos += 1
            while d < v and pq and -pq[0] >= i:
                d += 1
                q[-heapq.heappop(pq) + 1] -= 1
            if v > d:
                return -1
        return len(pq)
