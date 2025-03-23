class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        if len(s) % 2:
            return False
        mx = mi = 0
        for c, lock in zip(s, locked):
            if lock == '1':
                v = 1 if c == '(' else -1
                mx += v
                if mx < 0:
                    return False
                mi += v
            else:
                mx += 1
                mi -= 1
            if mi < 0:
                mi = 1
        return mi == 0