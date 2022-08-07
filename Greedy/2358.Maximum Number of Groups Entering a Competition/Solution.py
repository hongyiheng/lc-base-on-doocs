class Solution:
    def maximumGroups(self, grades: List[int]) -> int:
        n, m, k, ans = len(grades), 1, 0, 0
        for _ in range(n):
            k += 1
            if k == m:
                k = 0
                m += 1
                ans += 1
        return ans