class Solution:
    def removeTrailingZeros(self, num: str) -> str:
        i = len(num)
        while i > 0 and num[i - 1] == '0':
            i -= 1
        return num[:i]