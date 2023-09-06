class Solution:
    def strWithout3a3b(self, a: int, b: int) -> str:
        ans = ""
        while a or b:
            if a >= b:
                if len(ans) >= 2 and ans[-2:] == 'aa':
                    ans += 'b'
                    b -= 1
                else:
                    ans += 'a'
                    a -= 1
            else:
                if len(ans) >= 2 and ans[-2:] == 'bb':
                    ans += 'a'
                    a -= 1
                else:
                    ans += 'b'
                    b -= 1
        return ans