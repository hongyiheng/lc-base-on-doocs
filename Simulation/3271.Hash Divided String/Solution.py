class Solution:
    def stringHash(self, s: str, k: int) -> str:
        ans = []
        for i in range(0, len(s), k):
            v = 0
            for j in range(i, i + k):
                v += ord(s[j]) - ord('a')
            ans.append(chr(v % 26 + ord('a')))
        return "".join(ans)