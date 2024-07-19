class Solution:
    def minimumLevels(self, possible: List[int]) -> int:
        n, s = len(possible), 0
        for i in range(1, n):
            s += -1 if not possible[i] else 1
        t = -1 if not possible[0] else 1
        for i in range(1, n - 1):
            if t > s:
                return i
            t += -1 if not possible[i] else 1
            s -= -1 if not possible[i] else 1
        return n - 1 if t > s else -1