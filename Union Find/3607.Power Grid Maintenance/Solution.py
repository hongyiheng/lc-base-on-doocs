class Solution:
    def processQueries(self, c: int, connections: List[List[int]], queries: List[List[int]]) -> List[int]:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        p = list(range(c + 1))
        online = [True] * (c + 1)
        for u, v in connections:
            p[find(u)] = find(v)

        g = defaultdict(SortedList)
        for i in range(1, c + 1):
            g[find(i)].add(i)
        ans = []
        for o, v in queries:
            if o == 1:
                if online[v]:
                    ans.append(v)
                else:
                    ans.append(g[find(v)][0] if g[find(v)] else -1)
            else:
                online[v] = False
                if v in g[find(v)]:
                    g[find(v)].remove(v)
        return ans

