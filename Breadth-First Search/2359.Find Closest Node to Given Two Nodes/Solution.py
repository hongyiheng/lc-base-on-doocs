class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        def bfs(u):
            n = len(edges)
            dis = [inf] * n
            d = 0
            while u != -1 and dis[u] > d:
                dis[u] = d
                d += 1
                u = edges[u]
            return dis

        dis1, dis2 = bfs(node1), bfs(node2)
        ans, mi = -1, inf
        for i in range(len(dis1)):
            d = max(dis1[i], dis2[i])
            if d < mi:
                mi = d
                ans = i
        return ans


