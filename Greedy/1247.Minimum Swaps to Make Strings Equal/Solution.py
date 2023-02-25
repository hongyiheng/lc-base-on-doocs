class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        cnt = [0, 0]
        for a, b in zip(s1, s2):
            if a != b:
                cnt[ord(a) % 2] += 1
        d = cnt[0] + cnt[1]
        return -1 if d % 2 else d // 2 + cnt[0] % 2