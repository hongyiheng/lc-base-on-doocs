from sortedcontainers import SortedList

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        edges = [Edge(0, 0, 0)] * (n * n)
        head = [0] * n
        idx = 1

        def add_edge(a, b, w):
            nonlocal edges, head, idx
            edges[idx] = Edge(b, head[a], w)
            head[a] = idx
            idx += 1

        for e in flights:
            add_edge(e[0], e[1], e[2])
        dist = [float('inf')] * n
        q = SortedList(key=lambda x: x[1])
        q.add([src, 0])
        while k >= 0 and q:
            tmp = list()
            while q:
                p, w = q.pop()
                j = head[p]
                while j != 0:
                    if dist[edges[j].to] > w + edges[j].w:
                        dist[edges[j].to] = w + edges[j].w
                        tmp.append([edges[j].to, w + edges[j].w])
                    j = edges[j].next
            for v in tmp:
                q.add([v[0], v[1]])
            k -= 1
        return dist[dst] if dist[dst] != float('inf') else -1

class Edge:
    to = 0
    next = 0
    w = 0

    def __init__(self):
        return

    def __init__(self, to, next, w):
        self.to = to
        self.next = next
        self.w = w