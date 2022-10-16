class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        def dfs(i, c):
            color[i] = c
            for j in g[i]:
                if color[j] == c:
                    return False
                if color[j] == -1 and not dfs(j, c ^ 1):
                    return False
            return True

        g = defaultdict(list)
        for a, b in dislikes:
            g[a].append(b)
            g[b].append(a)
        color = [-1] * (n + 1)
        for i in range(1, n + 1):
            if color[i] == -1:
                if not dfs(i, 1):
                    return False
        return True
