class MedianFinder:

    def __init__(self):
        self.min_heap = []
        self.max_heap = []


    def addNum(self, num: int) -> None:
        if len(self.min_heap) == 0:
            heapq.heappush(self.min_heap, -num)
            return
        if len(self.min_heap) == len(self.max_heap):
            if self.min_heap[0] * -1 > num:
                heapq.heappush(self.min_heap, -num)
            else:
                heapq.heappush(self.max_heap, num)
        elif len(self.min_heap) > len(self.max_heap):
            if self.min_heap[0] * -1 > num:
                heapq.heappush(self.min_heap, -num)
                heapq.heappush(self.max_heap, -1 * heapq.heappop(self.min_heap))
            else:
                heapq.heappush(self.max_heap, num)
        else:
            if self.min_heap[0] * -1 > num:
                heapq.heappush(self.min_heap, -num)
            else:
                heapq.heappush(self.max_heap, num)
                heapq.heappush(self.min_heap, -1 * heapq.heappop(self.max_heap))

    def findMedian(self) -> float:
        if len(self.max_heap) == len(self.min_heap):
            return ( self.max_heap[0] - self.min_heap[0]) / 2
        return self.max_heap[0] if len(self.max_heap) > len(self.min_heap) else -1 * self.min_heap[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()