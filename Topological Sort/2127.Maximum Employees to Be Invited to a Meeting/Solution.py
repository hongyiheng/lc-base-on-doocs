class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        n = len(favorite)
        ins = [0] * n
        for v in favorite:
            ins[v] += 1
        q = [i for i in range(n) if not ins[i]]
        dist = [0] * n
        while q:
            u = q.pop()
            v = favorite[u]
            dist[v] = max(dist[v], dist[u] + 1)
            ins[v] -= 1
            if not ins[v]:
                q.append(v)

        ans1 = ans2 = 0
        vis = set()
        for i in range(n):
            if not ins[i] or i in vis:
                continue
            j, d = favorite[i], 1
            while j != i:
                vis.add(j)
                j = favorite[j]
                d += 1
            if d == 2:
                ans2 += d + dist[i] + dist[favorite[i]]
            else:
                ans1 = max(ans1, d)
        return max(ans1, ans2)