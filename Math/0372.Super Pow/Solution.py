class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        mod = 1337

        def pow(a, b):
            nonlocal mod
            ans = 1
            a %= mod
            while b > 0:
                ans = ans * a % mod
                b -= 1
            return ans

        def dfs(index):
            nonlocal a, b
            if index < 0:
                return 1
            return pow(dfs(index - 1), 10) * pow(a, b[index]) % mod

        return dfs(len(b) - 1)