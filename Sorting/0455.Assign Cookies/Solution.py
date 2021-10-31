class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        list.sort(g)
        list.sort(s)
        i, j, res = 0, 0, 0
        while i < len(g) and j < len(s):
            if g[i] <= s[j]:
                i += 1
                res += 1
            j += 1
        return res