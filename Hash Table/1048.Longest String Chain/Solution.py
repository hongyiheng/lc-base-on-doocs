class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        mp = defaultdict(list)
        for w in words:
            mp[len(w)].append(w)
        ans = 0

        @cache
        def dfs(cur):
            nonlocal ans
            cnt = 1
            for w in mp[len(cur) + 1]:
                for i in range(len(w)):
                    if w[:i] + w[i + 1:] == cur:
                        cnt = max(cnt, dfs(w) + 1)
            return cnt

        for w in words:
            ans = max(ans, dfs(w))
        return ans
