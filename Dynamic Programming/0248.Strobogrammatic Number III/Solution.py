class Solution:
    def strobogrammaticInRange(self, low: str, high: str) -> int:
        m, n = len(low), len(high)
        dp = [list()] * (n + 2)
        dp[1] = ["0", "1", "8"]
        dp[2] = ["00", "11", "69", "88", "96"]
        idx = 3
        while idx <= n:
            tmp = []
            for s in dp[idx - 2]:
                tmp.append("0" + s + "0")
                tmp.append("1" + s + "1")
                tmp.append("6" + s + "9")
                tmp.append("8" + s + "8")
                tmp.append("9" + s + "6")
            dp[idx] = tmp
            idx += 1
        low_num, high_num = int(low), int(high)
        ans = 0
        while m <= n:
            for s in dp[m]:
                if len(s) > 1 and s[0] == '0':
                    continue
                num = int(s)
                if low_num <= num <= high_num:
                    ans += 1
            m += 1
        return ans


