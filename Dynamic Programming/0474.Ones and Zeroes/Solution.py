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
        dp = [[[0 for _ in range(n + 1)] for _ in range(m + 1)] for _ in range(strs_len)]
        for i in range(m + 1):
            for j in range(n + 1):
                dp[0][i][j] = 1 if i >= cnt[0][0] and j >= cnt[0][1] else 0
        for k in range(1, strs_len):
            zero, one = cnt[k][0], cnt[k][1]
            for i in range(m + 1):
                for j in range(n + 1):
                    a = dp[k - 1][i][j]
                    b = dp[k - 1][i - zero][j - one] + 1 if i >= zero and j >= one else 0
                    dp[k][i][j] = max(a, b)
        return dp[strs_len - 1][m][n]