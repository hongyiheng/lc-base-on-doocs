class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        row = sum(chalk)
        k %= row
        for i, v in enumerate(chalk):
            if k < v:
                return i
            k -= v
        return 0