class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        def f(x):
            nonlocal success
            l, r = 0, len(potions) - 1
            while l < r:
                mid = (l + r) >> 1
                if potions[mid] * x < success:
                    l = mid + 1
                else:
                    r = mid
            return len(potions) - r if potions[r] * x >= success else 0

        potions.sort()
        return [f(v) for v in spells]