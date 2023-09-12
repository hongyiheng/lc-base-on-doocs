class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        f = [[False] * numCourses for _ in range(numCourses)]
        for p, v in prerequisites:
            f[p][v] = True
        for k in range(numCourses):
            for i in range(numCourses):
                for j in range(numCourses):
                    f[i][j] |= f[i][k] and f[k][j]
        return [f[p][v] for p, v in queries]