class Solution:
    def kSimilarity(self, s1: str, s2: str) -> int:
        def next(s):
            idx = 0
            while idx < n and s[idx] == s2[idx]:
                idx += 1
            ans = []
            for i in range(idx + 1, n):
                if s[i] == s2[idx] and s[i] != s2[i]:
                    cs = list(s)
                    cs[i], cs[idx] = cs[idx], cs[i]
                    ans.append("".join(cs))
            return ans

        ans, n = 0, len(s1)
        q = deque()
        q.append(s1)
        vis = {s1}
        while True:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                if cur == s2:
                    return ans
                for ns in next(cur):
                    if ns in vis:
                        continue
                    vis.add(ns)
                    q.append(ns)
            ans += 1
