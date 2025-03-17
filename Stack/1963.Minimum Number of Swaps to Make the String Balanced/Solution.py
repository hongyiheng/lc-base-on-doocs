class Solution:
    def minSwaps(self, s: str) -> int:
        q = []
        for c in list(s):
            if c == ']' and q and q[-1] == '[':
                q.pop()
            else:
                q.append(c)
        return (len(q) // 2 + 1) // 2