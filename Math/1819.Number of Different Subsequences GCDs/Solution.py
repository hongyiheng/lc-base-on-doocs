class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)

        s = set(nums)
        mx = max(nums)
        ans = len(s)
        for i in range(1, (mx + 1) // 2):
            if i in s:
                continue
            g = 0
            for j in range(i * 2, mx + 1, i):
                if j in s:
                    g = gcd(g, j)
                    if g == i:
                        ans += 1
                        break
        return ans