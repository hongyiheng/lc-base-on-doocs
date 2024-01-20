class Solution:
    def countPairs(self, coordinates: List[List[int]], k: int) -> int:
        ans = 0
        cnt = defaultdict(int)
        for x, y in coordinates:
            for i in range(k + 1):
                nx, ny = i ^ x, (k - i) ^ y
                ans += cnt[(nx, ny)]
            cnt[(x, y)] += 1
        return ans
