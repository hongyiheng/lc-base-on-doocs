class Solution:
    def reinitializePermutation(self, n: int) -> int:
        ans, idx = 1, n // 2
        while True:
            if idx == 1:
                return ans
            if idx % 2 == 0:
                idx /= 2
            else:
                idx = n // 2 + (idx - 1) // 2
            ans += 1