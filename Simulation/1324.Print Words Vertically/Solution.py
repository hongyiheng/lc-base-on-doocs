class Solution:
    def printVertically(self, s: str) -> List[str]:
        ss = s.split(" ")
        n = 0
        for w in ss:
            n = max(n, len(w))
        ans = []
        for i in range(n):
            col = []
            for w in ss:
                col.append(w[i] if i < len(w) else " ")
            for j in range(len(col) - 1, -1, -1):
                if col[j] != " ":
                    ans.append("".join(col[:j + 1]))
                    break
        return ans