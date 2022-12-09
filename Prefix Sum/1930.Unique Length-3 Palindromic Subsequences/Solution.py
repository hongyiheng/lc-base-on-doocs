class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        pre, tail = [0] * 26, [0] * 26
        for c in s:
            pre[ord(c) - ord('a')] += 1
        vis = [[False] * 26 for _ in range(26)]
        ans = 0
        for i in range(len(s) - 1, -1, -1):
            idx = ord(s[i]) - ord('a')
            pre[idx] -= 1
            for j in range(26):
                if pre[j] == 0 or tail[j] == 0:
                    continue
                if vis[idx][j]:
                    continue
                ans += 1
                vis[idx][j] = True
            tail[idx] += 1
        return ans
