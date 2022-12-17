class Solution:
    def destroyTargets(self, nums: List[int], space: int) -> int:
        g = defaultdict(list)
        for v in nums:
            g[v % space].append(v)
        ans = mx = 0
        for q in g.values():
            cur, mi = len(q), min(q)
            if cur > mx or (cur == mx and mi < ans):
                ans = mi
                mx = cur
        return ans
