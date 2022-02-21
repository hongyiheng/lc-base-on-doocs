class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        path = deque()
        n = len(graph)
        ans = list()

        def dfs(path, cur):
            nonlocal graph
            if cur == n - 1:
                ans.append(list(path))
                return
            for v in graph[cur]:
                path.append(v)
                dfs(path, v)
                path.pop()

        path.append(0)
        dfs(path, 0)
        return ans