class Solution:
    def minimumRemoval(self, beans: List[int]) -> int:
        beans.sort()
        s, n = sum(beans), len(beans)
        ans = float('inf')
        for i, v in enumerate(beans):
            t = s - (n - i) * v
            ans = min(ans, t)
        return ans