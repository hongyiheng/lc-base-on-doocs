class Solution:
    def firstDayBeenInAllRooms(self, nextVisit: List[int]) -> int:
        n = len(nextVisit)
        MOD = int(1e9 + 7)
        f = [0] * n
        for i in range(1, n):
            f[i] = (f[i - 1] + 1 + f[i - 1] - f[nextVisit[i - 1]] + 1) % MOD
        return f[-1]