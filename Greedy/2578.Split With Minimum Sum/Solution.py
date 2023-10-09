class Solution:
    def splitNum(self, num: int) -> int:
        cnt = [0] * 10
        while num:
            cnt[num % 10] += 1
            num //= 10
        a = b = d = 0
        for i in range(1, len(cnt)):
            while cnt[i]:
                if d:
                    a = a * 10 + i
                else:
                    b = b * 10 + i
                d ^= 1
                cnt[i] -= 1
        return a + b