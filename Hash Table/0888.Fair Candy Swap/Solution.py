class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        sum1, sum2 = sum(aliceSizes), sum(bobSizes)
        diff = (sum1 - sum2) // 2
        rec = set(bobSizes)
        ans = None
        for x in aliceSizes:
            y = x - diff
            if y in rec:
                ans = [x, y]
                return ans
        return ans