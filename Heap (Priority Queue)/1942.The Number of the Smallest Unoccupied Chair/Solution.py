class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        n = len(times)
        ts = [[times[i][0], times[i][1], i] for i in range(n)]
        ts.sort(key=lambda x: x[0])
        back = []
        ids = [i for i in range(n)]
        for l, r, i in ts:
            while back and back[0][0] <= l:
                heapq.heappush(ids, heapq.heappop(back)[1])
            id = heapq.heappop(ids)
            if i == targetFriend:
                return id
            heapq.heappush(back, [r, id])
        return -1