class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stk = list()
        n = len(temperatures)
        res = [0] * n
        for i in range(n):
            while stk and temperatures[stk[-1]] < temperatures[i]:
                j = stk.pop()
                res[j] = i - j
            stk.append(i)
        return res