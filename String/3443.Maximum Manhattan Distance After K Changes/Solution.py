class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        def f(a, b):
            ans = cur = cnt = 0
            for c in s:
                if c == a or c == b:
                    cur += 1
                elif cnt < k:
                    cur += 1
                    cnt += 1
                else:
                    cur -= 1
                ans = max(ans, cur)
            return ans

        return max(f("N", "E"), f("N", "W"), f("S", "E"), f("S", "W"))
