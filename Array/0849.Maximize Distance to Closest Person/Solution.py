class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        n, ans = len(seats), 0
        for i in range(n):
            if seats[i]:
                break
            ans += 1
        cnt = 0
        for i in range(n - 1, -1, -1):
            if seats[i]:
                break
            cnt += 1
        ans = max(ans, cnt)
        cnt = 0
        for v in seats:
            if v:
                ans = max(ans, (cnt + 1) // 2)
                cnt = 0
            else:
                cnt += 1
        return ans