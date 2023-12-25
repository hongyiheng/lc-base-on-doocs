class Solution:
    def numOfBurgers(self, tomatoSlices: int, cheeseSlices: int) -> List[int]:
        l, r = 0, cheeseSlices
        while l < r:
            mid = (l + r) >> 1
            if mid * 4 + (cheeseSlices - mid) * 2 < tomatoSlices:
                l = mid + 1
            else:
                r = mid
        return [r, cheeseSlices - r] if r * 4 + (cheeseSlices - r) * 2 == tomatoSlices else []