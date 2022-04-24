class Solution:
    def binaryGap(self, n: int) -> int:
        ans, last = 0, -1
        for i in range(32):
            if ((1 << i) & n) != 0:
                if last != -1:
                    ans = max(ans, i - last)
                last = i
        return ans