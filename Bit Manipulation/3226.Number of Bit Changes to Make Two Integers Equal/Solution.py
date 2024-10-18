class Solution:
    def minChanges(self, n: int, k: int) -> int:
        ans = 0
        for i in range(31):
            if n >> i & 1 and not k >> i & 1:
                ans += 1
            if not n >> i & 1 and k >> i & 1:
                return -1
        return ans
