class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        q = [0] * 1010
        for n, u, v in trips:
            q[u] += n
            q[v] -= n
        s = 0
        for v in q:
            s += v
            if s > capacity:
                return False
        return True