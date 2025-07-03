class Solution:
    def kthCharacter(self, k: int) -> str:
        q = [0]
        while len(q) < k:
            nq = [v + 1 for v in q]
            q.extend(nq)
        return chr(q[k - 1] % 26 + ord('a'))


