class Solution:
    def maxNumberOfAlloys(self, n: int, k: int, budget: int, composition: List[List[int]], stock: List[int], cost: List[int]) -> int:
        def check(x, t, budget):
            for i, v in enumerate(composition[x]):
                if stock[i] >= t * v:
                    continue
                budget -= (t * v - stock[i]) * cost[i]
                if budget < 0:
                    return False
            return True

        ans = 0
        for i in range(k):
            l, r = 0, int(1e9)
            while l < r:
                mid = (l + r + 1) >> 1
                if check(i, mid, budget):
                    l = mid
                else:
                    r = mid - 1
            ans = max(ans, r)
        return ans
