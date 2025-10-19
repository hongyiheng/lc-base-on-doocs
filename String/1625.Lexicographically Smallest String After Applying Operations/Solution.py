class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        q = deque([s])
        vis = {s}
        ans = s
        while q:
            cur = q.popleft()
            if cur < ans:
                ans = cur
            t1 = ''.join([str((int(c) + a) % 10) if i % 2 else c for i, c in enumerate(cur)])
            t2 = cur[b:] + cur[:b]
            for t in (t1, t2):
                if t not in vis:
                    vis.add(t)
                    q.append(t)
        return ans
