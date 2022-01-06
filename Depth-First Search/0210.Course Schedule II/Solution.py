class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        edges = [[] for _ in range(numCourses)]
        vistied, res = [0] * numCourses, []
        circle = False

        def dfs(i):
            nonlocal circle
            vistied[i] = 1
            for j in edges[i]:
                if vistied[j] == 0:
                    dfs(j)
                    if circle:
                        return
                elif vistied[j] == 1:
                    circle = True
                    return
            vistied[i] = 2
            res.insert(0, i)

        for item in prerequisites:
            edges[item[1]].append(item[0])
        for i in range(numCourses):
            if circle:
                break
            if vistied[i] == 0:
                dfs(i)
        return [] if circle else res