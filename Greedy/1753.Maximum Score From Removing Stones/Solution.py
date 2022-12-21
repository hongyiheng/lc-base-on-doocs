class Solution:
    def maximumScore(self, a: int, b: int, c: int) -> int:
        q = [a, b, c]
        ans = 0
        while q[1]:
            if q[0] + q[1] > q[2]:
                q[0] -= 1
                q[1] -= 1
            else:
                q[1] -= 1
                q[2] -= 1
            ans += 1
            q.sort()
        return ans
