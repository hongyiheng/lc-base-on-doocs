class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        def f(t):
            ans = a = b = 0
            for v in nums:
                if v % 2 == t:
                    if b:
                        ans += b
                        b -= 1
                    else:
                        a += 1
                else:
                    if a:
                        ans += a - 1
                        a -= 1
                    else:
                        b += 1
            return ans if a <= 1 and not b else -1

        a, b = f(0), f(1)
        return min(a, b) if a != -1 and b != -1 else (a if b == -1 else b)

