class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        q = []
        for i, v in enumerate(points):
            dis = v[0] * v[0] + v[1] * v[1]
            heapq.heappush(q, [dis, i])
        ans = list()
        for _ in range(k):
            ans.append(points[heapq.heappop(q)[1]])
        return ans