class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        n = len(changed)
        if n % 2:
            return []
        changed.sort()
        g = defaultdict(int)
        for v in changed:
            g[v] += 1
        ans = []
        for v in changed:
            if not g[v]:
                continue
            if not g[v * 2]:
                return []
            g[v * 2] -= 1
            g[v] -= 1
            ans.append(v)
        return ans