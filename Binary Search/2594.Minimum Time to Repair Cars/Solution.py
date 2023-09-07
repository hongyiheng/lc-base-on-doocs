class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        l, r = 0, ranks[0] * cars * cars
        while l < r:
            mid = (l + r) >> 1
            cnt = 0
            for v in ranks:
                cnt += int(math.sqrt(mid / v))
            if cnt < cars:
                l = mid + 1
            else:
                r = mid
        return r