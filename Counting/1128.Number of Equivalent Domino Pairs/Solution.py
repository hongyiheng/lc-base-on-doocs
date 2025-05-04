class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        cnt = [[0] * 10 for _ in range(10)]
        ans = 0
        for a, b in dominoes:
            ans += cnt[a][b]
            cnt[a][b] += 1
            cnt[b][a] = cnt[a][b]
        return ans


        