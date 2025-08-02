class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        diff = defaultdict(int)
        for v in basket1:
            diff[v] += 1
        for v in basket2:
            diff[v] -= 1
        l, r = [], []
        for k in diff.keys():
            if diff[k] % 2:
                return -1
            while diff[k] > 0:
                l.append(k)
                diff[k] -= 2
            while diff[k] < 0:
                r.append(k)
                diff[k] += 2
        l.sort()
        r.sort(reverse=True)
        mi = min(min(basket1), min(basket2))
        ans = 0
        for a, b in zip(l, r):
            ans += min(a, b, 2 * mi)
        return ans