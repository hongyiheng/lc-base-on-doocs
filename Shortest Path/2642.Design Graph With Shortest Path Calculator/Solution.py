class Graph:

    def __init__(self, n: int, edges: List[List[int]]):
        self.n = n
        self.g = [[inf] * n for _ in range(n)]
        for u, v, w in edges:
            self.g[u][v] = w
        for i in range(n):
            self.g[i][i] = 0
        for k in range(self.n):
            for u in range(self.n):
                for v in range(self.n):
                    if self.g[u][k] == inf or self.g[k][v] == inf:
                        continue
                    self.g[u][v] = min(self.g[u][v], self.g[u][k] + self.g[k][v])

    def addEdge(self, edge: List[int]) -> None:
        self.g[edge[0]][edge[1]] = min(self.g[edge[0]][edge[1]], edge[2])
        for k in [edge[0], edge[1]]:
            for u in range(self.n):
                for v in range(self.n):
                    if self.g[u][k] == inf or self.g[k][v] == inf:
                        continue
                    self.g[u][v] = min(self.g[u][v], self.g[u][k] + self.g[k][v])

    def shortestPath(self, node1: int, node2: int) -> int:
        return -1 if self.g[node1][node2] == inf else self.g[node1][node2]



# Your Graph object will be instantiated and called as such:
# obj = Graph(n, edges)
# obj.addEdge(edge)
# param_2 = obj.shortestPath(node1,node2)