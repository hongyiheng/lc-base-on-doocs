class Solution:
    def nextBeautifulNumber(self, n: int) -> int:
        for v in range(n + 1, 0x3f3f3f3f):
            cnt = [0] * 10
            x = v
            while x:
                cnt[x % 10] += 1
                x //= 10
            bal = True
            for i in range(10):
                if cnt[i] and i != cnt[i]:
                    bal = False
                    break
            if bal:
                return v
        return -1