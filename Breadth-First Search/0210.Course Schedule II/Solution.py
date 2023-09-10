class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        g = defaultdict(list)
        to = [0] * numCourses
        for u, v in prerequisites:
            g[v].append(u)
            to[u] += 1
        q = deque()
        for i, v in enumerate(to):
            if not v:
                q.append(i)
        cnt = 0
        ans = []
        while q:
            v = q.pop()
            for u in g[v]:
                to[u] -= 1
                if to[u] == 0:
                    q.append(u)
            ans.append(v)
            cnt += 1
        return ans if numCourses == cnt else []
