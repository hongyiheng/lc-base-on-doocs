class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        m = len(potions)
        ans = [0] * len(spells)
        for i, s in enumerate(spells):
            l, r = 0, m - 1
            while l < r:
                mid = (l + r) >> 1
                if s * potions[mid] < success:
                    l = mid + 1
                else:
                    r = mid
            if s * potions[r] >= success:
                ans[i] = m - r
        return ans

