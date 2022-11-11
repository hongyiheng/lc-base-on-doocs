class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        cnt = [0] * 26
        l = r = mx = 0
        n = len(s)
        while r < n:
            idx = ord(s[r]) - ord('A')
            cnt[idx] += 1
            mx = max(mx, cnt[idx])
            if r - l + 1 > mx + k:
                cnt[ord(s[l]) - ord('A')] -= 1
                l += 1
            r += 1
        return r - l
