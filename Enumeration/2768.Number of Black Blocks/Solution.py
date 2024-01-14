class Solution:
    def countBlackBlocks(self, m: int, n: int, coordinates: List[List[int]]) -> List[int]:
        s = {(x, y) for x, y in coordinates}
        vis = set()
        ans = [0] * 5
        for x, y in coordinates:
            for i in range(max(0, x - 1), min(m - 1, x + 1)):
                for j in range(max(0, y - 1), min(n - 1, y + 1)):
                    if (i, j) in vis:
                        continue
                    vis.add((i, j))
                    cnt = 1 if (i, j) in s else 0
                    cnt += 1 if (i, j + 1) in s else 0
                    cnt += 1 if (i + 1, j) in s else 0
                    cnt += 1 if (i + 1, j + 1) in s else 0
                    ans[cnt] += 1
        ans[0] = (m - 1) * (n - 1) - len(vis)
        return ans
