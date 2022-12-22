class Solution:
    def maxScore(self, nums: List[int]) -> int:
        @cache
        def gcd(a, b):
            if b != 0:
                return gcd(b, a % b)
            return a

        def get_cnt(x):
            ans = 0
            while x:
                x -= x & -x
                ans += 1
            return ans

        n = len(nums)
        f = [0] * (1 << n)
        ans = 0
        for k in range(1 << n):
            cnt = get_cnt(k)
            if cnt % 2 != 0:
                continue
            for i in range(n):
                if k & (1 << i) == 0:
                    continue
                for j in range(i + 1, n):
                    if k & (1 << j) == 0:
                        continue
                    f[k] = max(f[k], f[k ^ (1 << i) ^ (1 << j)] + cnt // 2 * gcd(nums[i], nums[j]))
                    ans = max(f[k], ans)
        return ans