class Solution:
    def secondHighest(self, s: str) -> int:
        mx = ans = -1
        for c in s:
            if '0' <= c <= '9':
                num = ord(c) - ord('0')
                if num > mx:
                    ans = mx
                    mx = num
                elif ans < num < mx:
                    ans = num
        return ans
