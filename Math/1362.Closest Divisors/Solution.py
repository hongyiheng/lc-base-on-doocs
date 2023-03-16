class Solution:
    def closestDivisors(self, num: int) -> List[int]:
        mi = num + 1
        ans = []
        for i in range(1, int(math.sqrt(num + 2)) + 1):
            if (num + 1) % i == 0 and abs(i - (num + 1) // i) < mi:
                ans = [i, (num + 1) // i]
                mi = abs(i - (num + 1) // i)
            if (num + 2) % i == 0 and abs(i - (num + 2) // i) < mi:
                ans = [i, (num + 2) // i]
                mi = abs(i - (num + 2) // i)
        return ans
