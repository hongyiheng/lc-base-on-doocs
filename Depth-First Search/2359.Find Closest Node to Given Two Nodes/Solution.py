class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        n = len(edges)

        def get_distance(x):
            nonlocal edges, n
            dis = [float('inf')] * n
            d = 0
            while x != -1 and dis[x] == float('inf'):
                dis[x] = d
                d += 1
                x = edges[x]
            return dis

        d1 = get_distance(node1)
        d2 = get_distance(node2)
        ans, cur = -1, float('inf')
        for i in range(n):
            d = max(d1[i], d2[i])
            if d < cur:
                cur = d
                ans = i
        return ans