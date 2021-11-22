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
        mp = dict()

        def dfs(item_id):
            if item_id in mp:
                return mp[item_id]
            res = 0
            for e in employees:
                if e.id == item_id:
                    res = e.importance
                    if e.subordinates:
                        for subordinate_id in e.subordinates:
                            res += dfs(subordinate_id)
                    else:
                        break
            mp[item_id] = res
            return res

        return dfs(id)