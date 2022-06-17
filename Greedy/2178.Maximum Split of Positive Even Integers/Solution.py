class Solution:
    def maximumEvenSplit(self, finalSum: int) -> List[int]:
        ans = []
        if finalSum % 2 != 0:
            return ans
        cur = 2
        while cur * 2 < finalSum:
            finalSum -= cur
            ans.append(cur)
            cur += 2
        if finalSum > 0:
            ans.append(finalSum)
        return ans