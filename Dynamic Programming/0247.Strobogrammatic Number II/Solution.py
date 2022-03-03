class Solution:
    def findStrobogrammatic(self, n: int) -> List[str]:
        dp = [list()] * (n + 2)
        dp[1] = ["0", "1", "8"]
        dp[2] = ["11", "69", "88", "96", "00"]
        idx = 2
        while idx < n:
            idx += 1
            tmp = list()
            for s in dp[idx - 2]:
                tmp.append("6" + s + "9")
                tmp.append("9" + s + "6")
                tmp.append("8" + s + "8")
                tmp.append("1" + s + "1")
                tmp.append("0" + s + "0")
            dp[idx] = tmp
        dp[2] = ["11", "69", "88", "96"]
        if n > 2:
            tmp = list()
            for s in dp[n]:
                if s[0] != '0':
                    tmp.append(s)
            dp[n] = tmp
        return dp[n]