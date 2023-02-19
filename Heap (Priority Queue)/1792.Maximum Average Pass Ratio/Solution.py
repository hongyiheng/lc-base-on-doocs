class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        q = [(a / b - (a + 1) / (b + 1), a, b) for a, b in classes]
        heapq.heapify(q)
        while extraStudents:
            _, a, b = heapq.heappop(q)
            a, b = a + 1, b + 1
            heapq.heappush(q, (a / b - (a + 1) / (b + 1), a, b))
            extraStudents -= 1
        cnt = 0
        for _, a, b in q:
            cnt += a / b
        return cnt / len(classes)