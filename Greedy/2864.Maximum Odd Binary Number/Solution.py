class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        cnt = 0
        for c in s:
            if c == '1':
                cnt += 1
        return (cnt - 1) * '1' + (len(s) - cnt) * '0' + '1'