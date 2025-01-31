class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        n = len(s)
        ans = []
        for i in range(0, n, k):
            t = s[i:min(i + k, n)]
            if not i // k % 2:
                ans.append(t[::-1])
            else:
                ans.append(t)
        return "".join(ans)