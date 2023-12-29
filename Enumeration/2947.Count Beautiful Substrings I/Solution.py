class Solution:
    def beautifulSubstrings(self, s: str, k: int) -> int:
        n = len(s)
        ans = 0
        vs = {'a', 'e', 'i', 'o', 'u'}
        for w in range(2, n + 1, 2):
            l = r = 0
            v = c = 0
            while r < n:
                if s[r] in vs:
                    v += 1
                else:
                    c += 1
                if r - l + 1 == w:
                    if v == c and not (v * c) % k:
                        ans += 1
                    if s[l] in vs:
                        v -= 1
                    else:
                        c -= 1
                    l += 1
                r += 1
        return ans