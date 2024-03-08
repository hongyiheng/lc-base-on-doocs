class Solution:
    def minMovesToCaptureTheQueen(self, a: int, b: int, c: int, d: int, e: int, f: int) -> int:
        def check(i, j, dirs):
            for dir in dirs:
                x, y = i, j
                while True:
                    nx, ny = x + dir[0], y + dir[1]
                    if nx < 1 or nx > 8 or ny < 1 or ny > 8:
                        break
                    if (nx == a and ny == b) or (nx == c and ny == d):
                        break
                    if nx == e and ny == f:
                        return True
                    x, y = nx, ny
            return False

        ans1 = check(a, b, [[1, 0], [0, 1], [-1, 0], [0, -1]])
        ans2 = check(c, d, [[1, 1], [1, -1], [-1, 1], [-1, -1]])
        return 1 if ans1 or ans2 else 2