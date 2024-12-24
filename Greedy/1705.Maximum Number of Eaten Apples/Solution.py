class Solution:
    def eatenApples(self, apples: List[int], days: List[int]) -> int:
        q = []
        ans = i = 0
        while q or i < len(apples):
            if i < len(apples) and apples[i]:
                heapq.heappush(q, [i + days[i], apples[i]])
            while q and (q[0][0] <= i or q[0][1] == 0):
                heapq.heappop(q)
            if q:
                q[0][1] -= 1
                ans += 1
            i += 1
        return ans