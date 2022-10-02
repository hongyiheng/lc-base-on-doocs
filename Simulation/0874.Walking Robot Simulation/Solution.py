class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        x = y = ans = 0
        d = 1
        s = set()
        for a, b in obstacles:
            s.add((a, b))
        for c in commands:
            if c < 0:
                if c == -2:
                    d -= 1
                elif c == -1:
                    d += 1
                d = (d + 4) % 4
            else:
                while c > 0:
                    if d == 1:
                        if (x, y + 1) in s:
                            break
                        y += 1
                    elif d == 3:
                        if (x, y - 1) in s:
                            break
                        y -= 1
                    elif d == 0:
                        if (x - 1, y) in s:
                            break
                        x -= 1
                    else:
                        if (x + 1, y) in s:
                            break
                        x += 1
                    c -= 1
                ans = max(ans, x * x + y * y)
        return ans
