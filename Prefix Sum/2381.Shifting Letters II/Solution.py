class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        n = len(s)
        cnt = [0] * (n + 1)
        for l, r, d in shifts:
            cnt[l] += 1 if d == 1 else -1
            cnt[r + 1] -= 1 if d == 1 else -1
        cs = list(s)
        v = 0
        for i in range(n):
            v = v + cnt[i]
            if v < 0 or v > 26:
                v = (v + 26) % 26
            cur = ord(cs[i]) + v
            cs[i] = chr(cur - 26) if cur > ord('z') else chr(cur)
        return "".join(cs)