class Solution:
    def minimumCost(self, m: int, n: int, horizontalCut: List[int], verticalCut: List[int]) -> int:
        horizontalCut.sort(reverse=True)
        verticalCut.sort(reverse=True)
        i = j = ans = 0
        while i < m - 1 or j < n - 1:
            if i < m - 1 and j < n - 1:
                if horizontalCut[i] < verticalCut[j]:
                    ans += verticalCut[j] * (i + 1)
                    j += 1
                else:
                    ans += horizontalCut[i] * (j + 1)
                    i += 1
            elif i < m - 1:
                ans += horizontalCut[i] * (j + 1)
                i += 1
            else:
                ans += verticalCut[j] * (i + 1)
                j += 1
        return ans