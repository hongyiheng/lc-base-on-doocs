class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        idx = -1
        n = len(number)
        for i, c in enumerate(number):
            if c == digit:
                if i < n - 1 and number[i + 1] > c:
                    return number[0:i] + number[i + 1:n]
                idx = i
        return number[0:idx] + number[idx + 1:n]