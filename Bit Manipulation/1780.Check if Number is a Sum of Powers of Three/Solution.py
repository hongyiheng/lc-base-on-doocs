class Solution:
    def checkPowersOfThree(self, n: int) -> bool:
        for i in range(1 << 15):
            v = 0
            for j in range(15):
                if i >> j & 1:
                    v += 3 ** j
                if v > n:
                    break
            if v == n:
                return True
        return False
