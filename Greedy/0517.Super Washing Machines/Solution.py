class Solution:
    def findMinMoves(self, machines: List[int]) -> int:
        n = len(machines)
        t = sum(machines)
        if t % n:
            return -1
        avg = t // n
        diff = [0] * n
        ans = 0
        for i in range(n):
            diff[i] = machines[i] - avg
            ans = max(ans, diff[i])

        for i in range(n):
            ans = max(ans, abs(diff[i]))
            if i < n - 1:
                diff[i + 1] += diff[i]
        return ans
