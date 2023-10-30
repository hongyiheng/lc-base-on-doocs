class Solution:
    def maximumCostSubstring(self, s: str, chars: str, vals: List[int]) -> int:
        g = [i for i in range(1, 27)]
        for c, v in zip(chars, vals):
            g[ord(c) - ord('a')] = v
        ans = cnt = 0
        for c in s:
            cnt += g[ord(c) - ord('a')]
            cnt = max(cnt, 0)
            ans = max(ans, cnt)
        return ans
