class Solution:
    def largestTimeFromDigits(self, arr: List[int]) -> str:
        def dfs(v, mask):
            nonlocal ans
            if mask == (1 << 4) - 1:
                if v % 100 < 60 and v // 100 < 24:
                    ans = max(ans, v)
                return
            for i in range(4):
                if not mask >> i & 1:
                    dfs(v * 10 + arr[i], mask | 1 << i)

        ans = -1
        dfs(0, 0)
        if ans == -1:
            return ""
        h = str(ans // 100) if ans // 100 >= 10 else "0" + str(ans // 100)
        m = str(ans % 100) if ans % 100 >= 10 else "0" + str(ans % 100)
        return h + ":" + m