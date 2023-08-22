class Solution:
    def minWindow(self, s: str, t: str) -> str:
        cnt = Counter(t)
        n, k = len(s), len(cnt)
        l = r = 0
        ans = ""
        while r < n:
            if r < n and s[r] in cnt:
                cnt[s[r]] -= 1
                if cnt[s[r]] == 0:
                    k -= 1
            while k == 0:
                if not ans or r - l + 1 < len(ans):
                    ans = s[l:r + 1]
                if s[l] in cnt:
                    cnt[s[l]] += 1
                    if cnt[s[l]] == 1:
                        k += 1
                l += 1
            r += 1
        return ans