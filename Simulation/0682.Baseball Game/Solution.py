class Solution:
    def calPoints(self, operations: List[str]) -> int:
        ans = []
        for i, c in enumerate(operations):
            if c == '+':
                ans.append(ans[-2] + ans[-1])
            elif c == 'D':
                ans.append(ans[-1] * 2)
            elif c == 'C':
                ans.pop()
            else:
                ans.append(int(operations[i]))
        return sum(ans)