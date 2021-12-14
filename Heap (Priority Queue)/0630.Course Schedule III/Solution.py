class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        courses.sort(key=lambda x: x[1])
        cur, q = 0, []
        for c in courses:
            dur, end = c[0], c[1]
            heapq.heappush(q, dur * -1)
            cur += dur
            if cur > end:
                cur -= heapq.heappop(q) * -1
        return len(q)