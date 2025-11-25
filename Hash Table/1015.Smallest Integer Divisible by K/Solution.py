class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        cur = 1
        for i in range(1, k + 1):
            if cur % k == 0:
                return i
            cur = (cur % k * 10 + 1) % k
        return -1