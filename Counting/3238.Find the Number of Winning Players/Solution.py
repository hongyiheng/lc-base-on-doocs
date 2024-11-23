class Solution:
    def winningPlayerCount(self, n: int, pick: List[List[int]]) -> int:
        cnt = [[0] * 11 for _ in range(n)]
        ans = 0
        for i, v in pick:
            if ans >> i & 1:
                continue
            cnt[i][v] += 1
            if cnt[i][v] > i:
                ans |= 1 << i
        return ans.bit_count()