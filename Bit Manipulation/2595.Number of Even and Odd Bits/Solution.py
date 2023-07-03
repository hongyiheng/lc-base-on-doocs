class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        ans = [0, 0]
        for i in range(10):
            ans[i & 1] += n >> i & 1
        return ans