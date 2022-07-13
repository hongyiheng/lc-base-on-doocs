class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        cnt = [0] * (n + 1)
        cnt[0] = 1
        for i in range(1, n + 1):
            cnt[i] = cnt[i - 1] * i
        used = [False] * (n + 1)
        ans = ""
        for i in range(n - 1, -1, -1):
            num = cnt[i]
            for j in range(1, n + 1):
                if used[j]:
                    continue
                if k > num:
                    k -= num
                    continue
                ans += str(j)
                used[j] = True
                break
        return ans