"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        def dfs(i):
            e = es[i]
            if not e:
                return 0
            ans = e.importance
            for j in e.subordinates:
                ans += dfs(j)
            return ans

        es = [None] * 2010
        for e in employees:
            es[e.id] = e
        return dfs(id)