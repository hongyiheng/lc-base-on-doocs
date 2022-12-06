class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        s = set()
        ans = 0
        cur, word = "", word + "a"
        for c in word:
            if '0' <= c <= '9':
                cur += c
            else:
                if not cur:
                    continue
                v = int(cur)
                if v not in s:
                    ans += 1
                s.add(v)
                cur = ""
        return ans
