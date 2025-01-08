class Solution:
    def largestGoodInteger(self, num: str) -> str:
        mx, cnt = -1, 1
        for i in range(1, len(num)):
            if num[i - 1] == num[i]:
                cnt += 1
            else:
                cnt = 1
            if cnt >= 3 and int(num[i]) > mx:
                mx = int(num[i])
        return "" if mx == -1 else 3 * str(mx)