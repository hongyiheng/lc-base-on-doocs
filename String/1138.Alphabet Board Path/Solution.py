class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        x, y, m = 0, 0, 5
        ans = list()
        for c in target:
            v = ord(c) - ord('a')
            nx, ny = v // m, v % m
            if y > ny:
                ans.append((y - ny) * 'L')
            if x < nx:
                ans.append((nx - x) * 'D')
            if x > nx:
                ans.append((x - nx) * 'U')
            if y < ny:
                ans.append((ny - y) * 'R')
            ans.append('!')
            x, y = nx, ny
        return "".join(ans)