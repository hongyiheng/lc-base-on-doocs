class Solution:
    def convert(self, s: str, numRows: int) -> str:
        n = len(s)
        if n <= numRows or numRows == 1:
            return s
        t = (n + numRows - 1) // numRows
        c = (t - 1) * (numRows - 2) + t
        dic = [[""] * c for _ in range(numRows)]
        x = y = index = d = 0
        dirs = [[-1, 1], [1, 0]]
        while index < n:
            dic[x][y] = s[index]
            index += 1
            if x == numRows - 1 or x == 0:
                d = 0 if d == 1 else 1
            x += dirs[d][0]
            y += dirs[d][1]
        return ''.join(ch for row in dic for ch in row if ch)