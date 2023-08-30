class Solution:
    def minimumJumps(self, forbidden: List[int], a: int, b: int, x: int) -> int:
        def dfs(cur, back):
            if cur == x:
                return 0
            if cur in ban or (cur, back) in vis:
                return inf
            if cur < 0 or cur > 6000:
                return inf
            vis.add((cur, back))
            ans = dfs(cur + a, False)
            if not back:
                ans = min(ans, dfs(cur - b, True))
            return ans + 1

        ban = set(forbidden)
        vis = set()
        ans = dfs(0, False)
        return -1 if ans == inf else ans
