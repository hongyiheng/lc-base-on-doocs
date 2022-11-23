class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        def lowbit(x):
            ans = 0
            while x > 0:
                x -= x & -x
                ans += 1
            return ans

        cnt = [0] * 32
        k = lowbit(num2)
        for i in range(31, -1, -1):
            if (1 << i) & num1:
                cnt[i] = 1
                k -= 1
                if k == 0:
                    break
        ans = 0
        for i in range(31):
            if cnt[i] == 0 and k > 0:
                cnt[i] = 1
                k -= 1
            if cnt[i] == 1:
                ans += (1 << i)
        return ans
