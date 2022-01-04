class Solution:
    def catMouseGame(self, graph: List[List[int]]) -> int:
        N, n = 51, len(graph)
        f = [[[0] * N for _ in range(N)] for _ in range(2 * N)]
        for k in range(2 * n):
            for i in range(n):
                for j in range(n):
                    f[k][i][j] = -1

        def dfs(k, mouse, cat):
            ans = f[k][mouse][cat]
            if ans != -1:
                return ans
            if mouse == 0:
                f[k][mouse][cat] = 1
                return 1
            elif mouse == cat:
                f[k][mouse][cat] = 2
                return 2
            elif k >= 2 * n:
                f[k][mouse][cat] = 0
                return 0
            if k % 2 == 0:
                win, draw = False, False
                for cur in graph[mouse]:
                    t = dfs(k + 1, cur, cat)
                    if t == 1:
                        win = True
                        break
                    if t == 0:
                        draw = True
                if win:
                    ans = 1
                elif draw:
                    ans = 0
                else:
                    ans = 2
            else:
                win, draw = False, False
                for cur in graph[cat]:
                    if cur == 0:
                        continue
                    t = dfs(k + 1, mouse, cur)
                    if t == 2:
                        win = True
                        break
                    if t == 0:
                        draw = True
                if win:
                    ans = 2
                elif draw:
                    ans = 0
                else:
                    ans = 1
            f[k][mouse][cat] = ans
            return ans

        return dfs(0, 1, 2)