class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        q = []
        n, cnt, use = len(heights), 0, 0
        for i in range(1, n):
            if heights[i - 1] >= heights[i]:
                continue
            gap = heights[i] - heights[i - 1]
            heapq.heappush(q, -gap)
            cnt += gap
            if cnt > bricks:
                if use < ladders:
                    use += 1
                    cnt += heapq.heappop(q)
                else:
                    return i - 1
        return len(heights) - 1