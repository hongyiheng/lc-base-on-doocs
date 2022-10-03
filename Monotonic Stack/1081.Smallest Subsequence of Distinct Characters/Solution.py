class Solution:
    def smallestSubsequence(self, s: str) -> str:
        cnt = Counter(list(s))
        q = []
        used = set()
        for c in s:
            if c not in used:
                while q and q[-1] > c and cnt[q[-1]] > 0:
                    used.remove(q.pop())
                q.append(c)
                used.add(c)
            cnt[c] -= 1
        return "".join(q)
