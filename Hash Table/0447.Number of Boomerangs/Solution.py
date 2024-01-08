class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        n, ans = len(points), 0
        for i in range(n):
            cnt = defaultdict(int)
            for j in range(n):
                if i == j:
                    continue
                x = points[j][0] - points[i][0]
                y = points[j][1] - points[i][1]
                d = x * x + y * y
                if d in cnt:
                    ans += cnt[d] * 2
                cnt[d] += 1
        return ans

