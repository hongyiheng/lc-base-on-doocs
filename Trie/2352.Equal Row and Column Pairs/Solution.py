class Node:
    def __init__(self):
        self.child = dict()
        self.cnt = 0

class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        n = len(grid)
        root = Node()

        def insert(row):
            nonlocal root
            head = root
            for v in row:
                if v not in head.child:
                    head.child[v] = Node()
                head = head.child[v]
            head.cnt += 1

        for row in grid:
            insert(row)
        ans = 0
        for j in range(n):
            head = root
            for i in range(n):
                v = grid[i][j]
                if v not in head.child:
                    break
                head = head.child[v]
            ans += head.cnt
        return ans