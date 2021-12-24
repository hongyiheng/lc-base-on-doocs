class Solution:
    def eatenApples(self, apples: List[int], days: List[int]) -> int:
        cur, ans, n = 0, 0, len(apples)
        stk = []
        while cur < n:
            if apples[cur] > 0:
                heapq.heappush(stk, [cur + days[cur], apples[cur]])
            while stk and (stk[0][0] <= cur or stk[0][1] == 0):
                heapq.heappop(stk)
            if stk:
                stk[0][1] -= 1
                ans += 1
            cur += 1
        while stk:
            while stk and (stk[0][0] <= cur or stk[0][1] == 0):
                heapq.heappop(stk)
            if stk:
                stk[0][1] -= 1
                ans += 1
            cur += 1
        return ans