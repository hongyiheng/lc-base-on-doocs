class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        n = len(word)
        ans = 0
        for i in range(n):
            g = defaultdict(int)
            t = 0
            for j in range(i, n):
                c = word[j]
                if c in {'a', 'e', 'i', 'o', 'u'}:
                    g[c] += 1
                else:
                    t += 1
                if len(g.keys()) == 5 and t == k:
                    ans += 1
                if t > k:
                    break
        return ans


