class Solution:
    def distinctEchoSubstrings(self, text: str) -> int:
        def getNxt(s):
            nxt = [0] * len(s)
            i, j = 1, 0
            while i < len(s):
                if s[i] == s[j]:
                    j += 1
                    nxt[i] = j
                    i += 1
                elif j:
                    j = nxt[j - 1]
                else:
                    i += 1
            return nxt

        ans = set()
        for i in range(len(text)):
            nxt = getNxt(text[i:])
            for j, v in enumerate(nxt):
                if not v or (j + 1) % 2:
                    continue
                if (j + 1) % (j + 1 - v) == 0 and (j + 1) // (j + 1 - v) % 2 == 0:
                    ans.add(text[i:i + j + 1])
        return len(ans)
