class Edge:
    def __init__(self, to, next, w):
        self.to = to
        self.next = next
        self.w = w

class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        n = len(distance)
        edges = [None] * (n * 2 + 1)
        head = [0] * n
        idx = 1

        def add_edge(a, b, w):
            nonlocal idx, edges, head
            edges[idx] = Edge(b, head[a], w)
            head[a] = idx
            idx += 1

        for i, w in enumerate(distance):
            add_edge(i, (i + 1) % n, w)
            add_edge((i + 1) % n, i, w)
        q = [[0, start]]
        dist = [float('inf')] * n
        dist[start] = 0
        while q:
            cur = heapq.heappop(q)[1]
            i = head[cur]
            while i:
                e = edges[i].to
                if dist[e] > dist[cur] + edges[i].w:
                    dist[e] = dist[cur] + edges[i].w
                    heapq.heappush(q, [dist[e], e])
                i = edges[i].next
        return dist[destination]