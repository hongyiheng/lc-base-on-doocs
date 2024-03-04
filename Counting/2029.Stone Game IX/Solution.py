class Solution:
    def lastNonEmptyString(self, s: str) -> str:
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        mx = max(cnt)
        cnt = [0] * 26
        ans = []
        for c in s:
            idx = ord(c) - ord('a')
            cnt[idx] += 1
            if cnt[idx] == mx:
                ans.append(c)
        return "".join(ans)