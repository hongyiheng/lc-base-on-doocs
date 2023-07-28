class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        g = defaultdict(list)
        ins = [0] * (n + 1)
        for u, v in relations:
            g[u].append(v)
            ins[v] += 1
        dist = [0] * (n + 1)
        q = []
        for i in range(1, n + 1):
            if ins[i] == 0:
                q.append(i)
                dist[i] = time[i - 1]
        while q:
            u = q.pop()
            for v in g[u]:
                ins[v] -= 1
                dist[v] = max(dist[v], dist[u] + time[v - 1])
                if ins[v] == 0:
                    q.append(v)
        return max(dist)