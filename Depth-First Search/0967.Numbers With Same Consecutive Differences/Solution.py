class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        def dfs(x):
            if len(str(x)) == n:
                ans.append(x)
                return
            last = x % 10
            if last - k >= 0:
                dfs(x * 10 + last - k)
            if k != 0 and last + k < 10:
                dfs(x * 10 + last + k)

        ans = []
        for i in range(1, 10):
            dfs(i)
        return ans