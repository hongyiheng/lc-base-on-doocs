class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        ps = [[p, s] for p, s in zip(position, speed)]
        ps.sort()
        q = deque()
        for i in range(len(position) - 1, -1, -1):
            t = (target - ps[i][0]) / ps[i][1]
            while not q or q[-1] < t:
                q.append(t)
        return len(q)