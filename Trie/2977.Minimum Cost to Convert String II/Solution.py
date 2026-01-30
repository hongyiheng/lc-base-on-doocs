class Node:
    def __init__(self):
        self.son = [None] * 26
        self.sid = -1


class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        def insert(s):
            o = root
            for c in s:
                i = ord(c) - ord('a')
                if o.son[i] is None:
                    o.son[i] = Node()
                o = o.son[i]
            if o.sid < 0:
                nonlocal sid
                o.sid = sid
                sid += 1
            return o.sid

        root = Node()
        sid = 0
        m = len(cost)
        dis = [[inf] * (m * 2) for _ in range(m * 2)]
        for x, y, c in zip(original, changed, cost):
            x = insert(x)
            y = insert(y)
            dis[x][y] = min(dis[x][y], c)
        for k in range(sid):
            for i in range(sid):
                if dis[i][k] == inf:
                    continue
                for j in range(sid):
                    dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j])

        @cache
        def dfs(i):
            nonlocal n
            if i >= n:
                return 0
            res = inf
            if source[i] == target[i]:
                res = dfs(i + 1)
            p, q = root, root
            for j in range(i, n):
                p = p.son[ord(source[j]) - ord('a')]
                q = q.son[ord(target[j]) - ord('a')]
                if p is None or q is None:
                    break
                if p.sid < 0 or q.sid < 0:
                    continue
                res = min(res, dis[p.sid][q.sid] + dfs(j + 1))
            return res

        n = len(source)
        ans = dfs(0)
        return ans if ans < inf else -1
