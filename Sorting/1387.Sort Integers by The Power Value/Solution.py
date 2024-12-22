class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        def f(x):
            ans = 0
            while x != 1:
                if x % 2 == 0:
                    x //= 2
                else:
                    x = 3 * x + 1
                ans += 1
            return ans

        q = [(f(i), i) for i in range(lo, hi + 1)]
        q.sort(key=lambda x: (x[0], x[1]))
        return q[k - 1][1]