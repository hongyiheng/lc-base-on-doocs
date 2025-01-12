class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        f = [0] * 32
        for v in candidates:
            for i in range(32):
                if v >> i & 1:
                    f[i] += 1
        return max(f)