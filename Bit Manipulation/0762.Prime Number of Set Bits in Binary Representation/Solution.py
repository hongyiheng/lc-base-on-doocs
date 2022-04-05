class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        dic = [False] * 32
        for i in [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]:
            dic[i] = True
        ans = 0
        for v in range(left, right + 1):
            x, cnt = v, 0
            while x:
                x -= (x & -x)
                cnt += 1
            if dic[cnt]:
                ans += 1
        return ans