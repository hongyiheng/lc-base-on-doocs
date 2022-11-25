class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        def check(s, t):
            n, m = len(s), len(t)
            if m > n:
                return False
            l1 = l2 = r1 = r2 = 0
            while r1 < n and r2 < m:
                if s[l1] != t[l2]:
                    return False
                c = s[l1]
                while r1 < n and s[r1] == c:
                    r1 += 1
                while r2 < m and t[r2] == c:
                    r2 += 1
                len1, len2 = r1 - l1, r2 - l2
                if len1 < len2 or (len1 > len2 and len1 < 3):
                    return False
                l1, l2 = r1, r2
            return r1 == n and r2 == m

        return sum(check(s, t) for t in words)
