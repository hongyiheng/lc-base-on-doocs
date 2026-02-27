class Solution:
    def minAllOneMultiple(self, k: int) -> int:
        if k % 2 == 0 or k % 5 == 0:
            return -1
        x = 0
        for i in range(1, k + 1):
            x = (x * 10 + 1) % k
            if x == 0:
                return i
        return -1