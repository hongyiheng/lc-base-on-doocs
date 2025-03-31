class Solution:
    def percentageLetter(self, s: str, letter: str) -> int:
        cnt = sum([1 if c == letter else 0 for c in s])
        return int(cnt / len(s) * 100)