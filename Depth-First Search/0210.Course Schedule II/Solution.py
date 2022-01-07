class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        edges = [[] for _ in range(numCourses)]
        visited, res = [0] * numCourses, []
        circle = False

        def dfs(i):
            nonlocal circle
            visited[i] = 1
            for j in edges[i]:
                if visited[j] == 0:
                    dfs(j)
                    if circle:
                        return
                elif visited[j] == 1:
                    circle = True
                    return
            visited[i] = 2
            res.insert(0, i)

        for item in prerequisites:
            edges[item[1]].append(item[0])
        for i in range(numCourses):
            if circle:
                break
            if visited[i] == 0:
                dfs(i)
        return [] if circle else res