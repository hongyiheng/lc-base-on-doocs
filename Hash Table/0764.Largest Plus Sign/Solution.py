class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: List[List[int]]) -> int:
        g = set()
        row, col = defaultdict(list), defaultdict(list)
        for i, j in mines:
            g.add((i, j))
            row[i].append((i, j))
            col[j].append((i, j))
        ans = 0
        for i in range(n):
            for j in range(n):
                if (i, j) not in g:
                    r, c = min(n - j, j + 1), min(n - i, i + 1)
                    rs, cs = row[i], col[j]
                    for x, y in rs:
                        r = min(r, abs(y - j))
                    for x, y in cs:
                        c = min(c, abs(x - i))
                    ans = max(ans, min(r, c))
        return ans
