class Solution:
    def subarrayGCD(self, nums: List[int], k: int) -> int:
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)

        ans, n = 0, len(nums)
        for i in range(n):
            g = 0
            for j in range(i, n):
                g = gcd(g, nums[j])
                if g == k:
                    ans += 1
        return ans
