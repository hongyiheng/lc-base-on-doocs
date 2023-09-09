class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = defaultdict(list)
        to = [0] * numCourses
        for u, v in prerequisites:
            g[v].append(u)
            to[u] += 1
        q = deque([i for i, v in enumerate(to) if not v])
        cnt = 0
        while q:
            v = q.pop()
            for u in g[v]:
                to[u] -= 1
                if to[u] == 0:
                    q.append(u)
            cnt += 1
        return cnt == numCourses

