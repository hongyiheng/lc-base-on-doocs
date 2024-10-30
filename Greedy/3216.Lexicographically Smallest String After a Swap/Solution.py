class Solution:
    def getSmallestString(self, s: str) -> str:
        ans = list(s)
        for i in range(1, len(ans)):
            last, v = int(ans[i - 1]), int(ans[i])
            if last > v and last % 2 == v % 2:
                ans[i - 1], ans[i] = ans[i], ans[i - 1]
                break
        return "".join(ans)