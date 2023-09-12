class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        @cache
        def dfs(v):
            if not g[v]:
                return []
            for p in g[v]:
                g[v] = g[v].union(dfs(p))
            return g[v]

        g = defaultdict(set)
        for p, v in prerequisites:
            g[v].add(p)
        for i in range(numCourses):
            dfs(i)
        return [p in g[v] for p, v in queries]