class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:
        n = len(t)
        ans = [0] * n
        q = deque()
        for i in range(n):
            while q and t[q[-1]] < t[i]:
                idx = q.pop()
                ans[idx] = i - idx
            q.append(i)
        return ans