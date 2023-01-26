class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        s = [1] * n
        k -= n
        idx = n - 1
        while k > 0:
            s[idx] += min(25, k)
            idx -= 1
            k -= 25
        ans = [chr(v + ord('a') - 1) for v in s]
        return "".join(ans)