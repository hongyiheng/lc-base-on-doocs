class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        def dfs(l, r):
            nonlocal expression
            ans = []
            for i in range(l, r + 1):
                if '0' <= expression[i] <= '9':
                    continue
                left, right = dfs(l, i - 1), dfs(i + 1, r)
                for a in left:
                    for b in right:
                        if expression[i] == '+':
                            ans.append(a + b)
                        elif expression[i] == '-':
                            ans.append(a - b)
                        else:
                            ans.append(a * b)
            if not ans:
                ans.append(int(expression[l:r + 1]))
            return ans

        return dfs(0, len(expression) - 1)