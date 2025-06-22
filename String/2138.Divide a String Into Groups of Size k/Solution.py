class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        ans = []
        n = len(s)
        for i in range(0, n, k):
            v = s[i:min(n, i + k)]
            while len(v) < k:
                v += fill
            ans.append(v)
        return ans