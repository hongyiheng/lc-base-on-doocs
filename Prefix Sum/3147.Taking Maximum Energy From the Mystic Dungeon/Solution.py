class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        f = [0] * k
        for i, v in enumerate(energy):
            f[i % k] = max(f[i % k] + v, v)
        return max(f)