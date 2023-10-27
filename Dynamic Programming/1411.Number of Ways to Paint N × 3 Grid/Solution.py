class Solution:
    def numOfWays(self, n: int) -> int:
        M = int(1e9 + 7)
        # 三色 f1, 双色 f2
        f1 = f2 = 6
        for i in range(1, n):
            # 每个三色的下一行, 有 2 个三色, 2 个双色
            # 每个双色的下一行, 有 2 个三色, 3 个双色
            nf1 = f1 * 2 + f2 * 2
            nf2 = f1 * 2 + f2 * 3
            f1, f2 = nf1 % M, nf2 % M
        return (f1 + f2) % M