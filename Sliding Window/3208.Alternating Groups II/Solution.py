class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        n = len(colors)
        ans, cnt = 0, 1
        for i in range(1, len(colors) * 2):
            if colors[i % n] == colors[(i - 1) % n]:
                cnt = 0
            cnt += 1
            if i >= n and cnt >= k:
                ans += 1
        return ans