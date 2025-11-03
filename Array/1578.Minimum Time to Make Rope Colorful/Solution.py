class Solution:
    def minCost(self, s: str, cost: List[int]) -> int:
        ans = 0
        l = len(s)
        i = 0
        if l <= 1:
            return 0
        while i < l - 1:
            if s[i] == s[i + 1]:
                left = i
                while i < l - 1 and s[i] == s[i + 1]:
                    i += 1
                right = i + 1
                ans += sum(cost[left:right]) - max(cost[left:right])
            else:
                i += 1
        return ans