class Solution:
    def shortestPalindrome(self, s: str) -> str:
        def getNxt(s):
            nxt = [0]
            i, j = 1, 0
            while i < len(s):
                if s[i] == s[j]:
                    i += 1
                    j += 1
                    nxt.append(j)
                elif j:
                    j = nxt[j - 1]
                else:
                    nxt.append(0)
                    i += 1
            return nxt

        nxt = getNxt(s + '#' + s[::-1])
        return s[::-1][:len(s) - nxt[-1]] + s