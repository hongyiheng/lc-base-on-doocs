class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        @cache
        def dfs(i):
            if i < 0:
                return 0
            x = ks[i]
            j = i
            while j and ks[j - 1] >= x - 2:
                j -= 1
            return max(dfs(i - 1), dfs(j - 1) + x * cnt[x])

        cnt = Counter(power)
        ks = sorted(cnt.keys())
        return dfs(len(ks) - 1)

