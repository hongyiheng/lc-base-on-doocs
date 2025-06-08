class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        def dfs(x):
            if x > n:
                return
            ans.append(x)
            for i in range(10):
                nx = x * 10 + i
                dfs(nx)

        if n < 10:
            return [i for i in range(1, n + 1)]
        ans = []
        for i in range(1, 10):
            dfs(i)
        return ans