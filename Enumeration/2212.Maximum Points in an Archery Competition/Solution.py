class Solution:
    def maximumBobPoints(self, numArrows: int, aliceArrows: List[int]) -> List[int]:
        ans = []
        max_ = 0
        for i in range(1 << 12):
            cur = use = 0
            tmp = [0] * 12
            for j in range(12):
                if i & (1 << j):
                    cur += j
                    use += aliceArrows[j] + 1
                    tmp[j] = aliceArrows[j] + 1
            if use > numArrows:
                continue
            if cur > max_:
                max_ = cur
                tmp[0] += numArrows - use
                ans = tmp[:]
        return ans