class Solution:
    def largestNumber(self, cost: List[int], target: int) -> str:
        f = [0] + [-0x3f3f3f3f] * (target + 1)
        for i in range(target + 1):
            for j in range(9):
                if cost[j] > i:
                    continue
                f[i] = max(f[i], f[i - cost[j]] + 1)
        if f[target] <= 0:
            return "0"
        ans = []
        for i in range(9, 0, -1):
            c = cost[i - 1]
            while target >= c and f[target - c] + 1 == f[target]:
                ans.append(str(i))
                target -= c
        return "".join(ans)