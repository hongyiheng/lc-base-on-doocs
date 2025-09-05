class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        for k in range(33):
            x = num1 - k * num2
            if x < k:
                continue
            if x.bit_count() > k:
                continue
            return k
        return -1
