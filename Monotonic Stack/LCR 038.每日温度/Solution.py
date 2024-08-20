class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans = [0] * len(temperatures)
        q = []
        for i, x in enumerate(temperatures):
            while q and temperatures[q[-1]] < x:
                j = q.pop()
                ans[j] = i - j
            q.append(i)
        return ans