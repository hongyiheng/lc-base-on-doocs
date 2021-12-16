class Solution:
    def countAndSay(self, n: int) -> str:
        def dfs(s):
            ans = ""
            cur, count = ord(s[0]) - ord('0'), 1
            for i in range(1, len(s)):
                num = ord(s[i]) - ord('0')
                if cur == num:
                    count += 1
                else:
                    ans += str(count)
                    ans += str(cur)
                    cur = num
                    count = 1
            ans += str(count)
            ans += str(cur)
            return ans

        ans = "1"
        for _ in range(n - 1):
            ans = dfs(ans)
        return ans