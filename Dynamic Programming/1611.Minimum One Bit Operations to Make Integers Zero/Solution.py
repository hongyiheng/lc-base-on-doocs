class Solution:
    def minimumOneBitOperations(self, n: int) -> int:
        for i in range(31, -1, -1):
            if n >> i & 1:
                return (1 << (i + 1)) - 1 - self.minimumOneBitOperations(n ^ (1 << i))
        return 0

