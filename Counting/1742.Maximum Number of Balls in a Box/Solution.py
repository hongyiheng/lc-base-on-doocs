class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        cnt = [0] * 46
        for i in range(lowLimit, highLimit + 1):
            num, index = i, 0
            while num :
                index += num % 10
                num //= 10
            cnt[index] += 1
        return max(cnt)