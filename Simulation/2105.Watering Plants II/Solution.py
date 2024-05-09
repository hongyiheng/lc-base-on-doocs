class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        l, r = 0, len(plants) - 1
        ac, bc = capacityA, capacityB
        ans = 0
        while l <= r:
            lv, rv = plants[l], plants[r]
            if l == r:
                if ac >= bc:
                    if lv > ac:
                        ans += 1
                else:
                    if lv > bc:
                        ans += 1
            else:
                if lv > ac:
                    ans += 1
                    ac = capacityA
                if rv > bc:
                    ans += 1
                    bc = capacityB
            ac -= lv
            bc -= rv
            l += 1
            r -= 1
        return ans
