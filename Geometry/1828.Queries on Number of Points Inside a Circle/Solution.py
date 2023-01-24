class Solution:
    def countPoints(self, points: List[List[int]], queries: List[List[int]]) -> List[int]:
        ans = []
        for x, y, r in queries:
            num = 0
            for i, j in points:
                d = math.sqrt(abs(x - i) ** 2 + abs(y - j) ** 2)
                if d <= r:
                    num += 1
            ans.append(num)
        return ans