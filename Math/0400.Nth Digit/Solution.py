class Solution:
    def findNthDigit(self, n: int) -> int:
        if n < 10:
            return n
        n -= 9
        i = 1
        while True:
            if n <= (i + 1) * 9 * 10 ** i:
                break
            n -= (i + 1) * 9 * 10 ** i
            i += 1
        n -= 1
        num = 10 ** i + n // (i + 1)
        return int(str(num)[n % (i + 1)])
