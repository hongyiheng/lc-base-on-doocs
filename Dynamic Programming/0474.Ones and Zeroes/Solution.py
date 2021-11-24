class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        strs_len = len(strs)
        cnt = [[0 for _ in range(2)] for _ in range(strs_len)]
        for k in range(strs_len):
            item = strs[k]
            zero, one = 0, 0
            for i in range(len(item)):
                if '0' == item[i]:
                    zero += 1
                else:
                    one += 1
            cnt[k][0] = zero
            cnt[k][1] = one
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for k in range(strs_len):
            zero, one = cnt[k][0], cnt[k][1]
            for i in range(m, zero - 1, -1):
                for j in range(n, one - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - zero][j - one] + 1)
        return dp[m][n]