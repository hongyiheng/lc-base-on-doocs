class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        n = len(words)
        l = r = startIndex
        for i in range(n):
            if words[(l + n - i) % n] == target or words[(r + n + i) % n] == target:
                return i
        return -1