class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        ans = 0
        q = []
        for a, b in costs:
            ans += a
            q.append(b - a)
        q.sort()
        ans += sum(q[:len(costs) // 2])
        return ans
