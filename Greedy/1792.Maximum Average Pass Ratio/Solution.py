class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
            q = [(p / t - (p + 1) / (t + 1), t, p) for p, t in classes]
            heapq.heapify(q)
            while extraStudents:
                _, t, p = heapq.heappop(q)
                t += 1
                p += 1
                heapq.heappush(q, (p / t - (p + 1) / (t + 1), t, p))
                extraStudents -= 1
            s = 0
            for _, t, p in q:
                s += p / t
            return s / len(classes)
