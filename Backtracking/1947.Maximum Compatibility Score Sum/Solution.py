class Solution:
    def maxCompatibilitySum(self, students: List[List[int]], mentors: List[List[int]]) -> int:
        def getScore(i, j):
            ans = 0
            for a, b in zip(students[i], mentors[j]):
                if a == b:
                    ans += 1
            return ans

        def dfs(i, use, cur):
            if i == n:
                return cur
            ans = cur
            for j in range(n):
                if use >> j & 1:
                    continue
                ans = max(ans, dfs(i + 1, use | (1 << j), cur + getScore(i, j)))
            return ans

        n = len(students)
        return dfs(0, 0, 0)