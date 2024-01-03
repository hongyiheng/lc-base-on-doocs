class Solution:
    def getMaxRepetitions(self, s1: str, n1: int, s2: str, n2: int) -> int:
        m, n = len(s1), len(s2)
        if m * n1 < n * n2:
            return 0
        i = j = 0
        ids = dict()
        while i < m * n1:
            if s1[i % m] == s2[j % n]:
                j += 1
                i += 1
                if not j % n:
                    if i % m in ids:
                        last_i, last_j = ids[i % m]
                        i_d = i - last_i
                        j_d = j - last_j
                        if i_d and (m * n1 - i) // i_d:
                            v = (m * n1 - i) // i_d
                            i += i_d * v
                            j += j_d * v
                    else:
                        ids[i % m] = (i, j)
            else:
                i += 1
        return j // n // n2
