class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        vis = set()
        ans = []
        for row in grid:
            for v in row:
                if v in vis:
                    ans.append(v)
                vis.add(v)
        for i in range(1, len(grid) ** 2 + 1):
            if i not in vis:
                ans.append(i)
                break
        return ans