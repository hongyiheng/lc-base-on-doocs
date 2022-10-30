class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        ans = 0
        q = deque()
        for v in heights:
            if q and q[-1] > v:
                n = 1
                while q and q[-1] > v:
                    cur = q.pop()
                    ans = max(ans, cur * n)
                    n += 1
                for i in range(n - 1):
                    q.append(v)
            q.append(v)
        while q:
            ans = max(ans, q.popleft() * (len(q) + 1))
        return ans
