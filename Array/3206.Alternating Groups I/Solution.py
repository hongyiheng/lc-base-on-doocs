class Solution:
    def numberOfAlternatingGroups(self, colors: List[int]) -> int:
        ans = (1 if colors[-1] == colors[1] != colors[0] else 0)
        ans += (1 if colors[0] == colors[-2] != colors[-1] else 0)
        for i in range(1, len(colors) - 1):
            if colors[i - 1] == colors[i + 1] != colors[i]:
                ans += 1
        return ans

