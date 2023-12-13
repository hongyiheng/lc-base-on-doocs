class Solution:
    def countPalindromePaths(self, parent: List[int], s: str) -> int:
        def dfs(u, mask):
            ans = 0
            for v in g[u]:
                nm = mask ^ (1 << (ord(s[v]) - ord('a')))
                ans += cnt[nm]
                for i in range(26):
                    ans += cnt[nm ^ (1 << i)]
                cnt[nm] += 1
                ans += dfs(v, nm)
            return ans

        g = defaultdict(list)
        for v, u in enumerate(parent):
            g[u].append(v)
        cnt = defaultdict(int)
        cnt[0] = 1
        return dfs(0, 0)