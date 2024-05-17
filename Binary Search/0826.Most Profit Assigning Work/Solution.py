class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        q = [[d, p] for d, p in zip(difficulty, profit)]
        q.sort(key=lambda x: (x[0], x[1]))
        stk = []
        for d, p in q:
            if stk and stk[-1][1] >= p:
                continue
            stk.append([d, p])
        ans = 0
        for w in worker:
            l, r = 0, len(stk) - 1
            while l < r:
                mid = (l + r + 1) >> 1
                if stk[mid][0] <= w:
                    l = mid
                else:
                    r = mid - 1
            if stk[r][0] <= w:
                ans += stk[r][1]
        return ans
