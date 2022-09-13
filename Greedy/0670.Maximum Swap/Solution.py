class Solution:
    def maximumSwap(self, num: int) -> int:
        s = list(str(num))
        n = len(s)
        for i in range(n):
            mx = 0
            for j in range(i + 1, n):
                if int(s[i]) < int(s[j]):
                    if mx == 0 or int(s[mx]) <= int(s[j]):
                        mx = j
            if mx != 0:
                s[i], s[mx] = s[mx], s[i]
                break
        return int("".join(s))