class Solution:
    def maximizeWin(self, prizePositions: List[int], k: int) -> int:
        n = len(prizePositions)
        f = [0] * (n + 1)
        l = r = ans = 0
        while r < n:
            while prizePositions[r] - prizePositions[l] > k:
                l += 1
            f[r + 1] = max(f[r], r - l + 1)
            ans = max(ans, r - l + 1 + f[l])
            r += 1
        return ans