class Solution:
    def circularGameLosers(self, n: int, k: int) -> List[int]:
        s = [False] * (n + 1)
        pos, cnt = 1, 0
        while not s[pos]:
            s[pos] = True
            cnt += 1
            pos = (pos + cnt * k - 1) % n + 1
        return [i for i in range(1, n + 1) if not s[i]]