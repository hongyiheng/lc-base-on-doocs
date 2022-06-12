class Solution:
    def countCollisions(self, directions: str) -> int:
        n = len(directions)
        l, r = 0, n - 1
        for i in range(n):
            if directions[i] == 'L':
                l += 1
            else:
                break
        for i in range(n - 1, -1, -1):
            if directions[i] == 'R':
                r -= 1
            else:
                break
        cnt = 0
        for i in range(l, r + 1):
            if directions[i] == 'S':
                cnt += 1
        return r - l + 1 - cnt