class Solution:
    def convertToBase7(self, num: int) -> str:
        if num == 0:
            return "0"
        flag = num > 0
        num = abs(num)
        ans = ""
        while num > 0:
            ans += str(num % 7)
            num //= 7
        return ans[::-1] if flag else "-" + ans[::-1]