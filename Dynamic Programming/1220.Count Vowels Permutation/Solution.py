class Solution:
    def countVowelPermutation(self, n: int) -> int:
        mod = 10 ** 9 + 7
        a, e, i, o, u = 1, 1, 1, 1, 1
        for _ in range(2, n + 1):
            na = (e + i + u) % mod
            ne = (a + i) % mod
            ni = (e + o) % mod
            no = i % mod
            nu = (i + o) % mod
            a, e, i, o, u = na, ne, ni, no, nu
        return (a + e + i + o + u) % mod