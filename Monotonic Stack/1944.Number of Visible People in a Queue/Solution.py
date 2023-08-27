class Solution:
    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        n = len(heights)
        ans = [0] * n
        q = []
        for i in range(n - 1, -1, -1):
            h = heights[i]
            cnt = 0
            while q and q[-1] < h:
                cnt += 1
                q.pop()
            ans[i] = cnt + 1 if q else cnt
            q.append(h)
        return ans
