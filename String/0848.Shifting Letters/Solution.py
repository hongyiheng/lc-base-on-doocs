class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        cs = list(s)
        n, offset = len(s), 0
        for i in range(n - 1, -1, -1):
            offset += shifts[i]
            cs[i] = chr((ord(s[i]) + offset - ord('a')) % 26 + ord('a'))
        return "".join(cs)
