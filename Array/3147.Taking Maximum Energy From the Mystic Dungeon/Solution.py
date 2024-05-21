class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        n = len(energy)
        ans = energy[-1]
        for i in range(n - 1, n - k - 1, -1):
            s = 0
            for j in range(i, -1, -k):
                s += energy[j]
                ans = max(ans, s)
        return ans