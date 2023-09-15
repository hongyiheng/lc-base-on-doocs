class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            p[find(a)] = find(b)

        def is_link():
            t = find(1)
            for i in range(1, n + 1):
                if find(i) != t:
                    return False
            return True

        p = [i for i in range(n + 1)]
        ans = 0
        for t, u, v in edges:
            if t == 3:
                if find(u) == find(v):
                    ans += 1
                else:
                    union(u, v)
        tmp = p[::]

        for t, u, v in edges:
            if t == 1:
                if find(u) == find(v):
                    ans += 1
                else:
                    union(u, v)
        if not is_link():
            return -1

        p = tmp
        for t, u, v in edges:
            if t == 2:
                if find(u) == find(v):
                    ans += 1
                else:
                    union(u, v)
        if not is_link():
            return -1

        return ans