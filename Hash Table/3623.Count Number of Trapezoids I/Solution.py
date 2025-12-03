class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        mod = int(1e9 + 7)
        row = defaultdict(int)
        for _, y in points:
            row[y] += 1
        ans = s = 0
        for k, v in row.items():
            if v >= 2:
                k = v * (v - 1) // 2
                ans += s * k
                s += k
        return ans % mod