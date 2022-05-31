class Solution:
    def gardenNoAdj(self, n: int, paths: List[List[int]]) -> List[int]:
        head = [0] * (n + 1)
        edges = [Edge] * (len(paths) * 2 + 1)
        idx = 1

        def add_edge(a, b):
            nonlocal edges, head, idx
            edges[idx] = Edge(b, head[a])
            head[a] = idx
            idx += 1

        for a, b in paths:
            add_edge(a - 1, b - 1)
            add_edge(b - 1, a - 1)
        ans = [0] * n
        cnt = [0] * n
        for i in range(n):
            k = 1
            while k <= 4:
                if cnt[i] & (1 << k) == 0:
                    ans[i] = k
                    break
                k += 1
            j = head[i]
            while j:
                cnt[edges[j].to] |= (1 << k)
                j = edges[j].next
        return ans

class Edge:
    to = 0
    next = 0

    def __init__(self, to, next):
        self.to = to
        self.next = next