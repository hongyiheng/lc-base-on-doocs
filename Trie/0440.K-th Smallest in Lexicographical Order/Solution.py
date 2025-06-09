class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def get_cnt(x):
            cnt = 0
            l, r = x, x + 1
            while l <= n:
                cnt += min(r, n + 1) - l
                l *= 10
                r *= 10
            return cnt

        cur = 1
        k -= 1
        while k > 0:
            cnt = get_cnt(cur)
            if k >= cnt:
                cur += 1
                k -= cnt
            else:
                cur *= 10
                k -= 1
        return cur


