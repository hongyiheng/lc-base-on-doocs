class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        def dfs():
            ans = 0
            for k in cnt.keys():
                if cnt[k] > 0:
                    ans += 1
                    cnt[k] -= 1
                    ans += dfs()
                    cnt[k] += 1
            return ans

        cnt = Counter(tiles)
        return dfs()