class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        t = [0] * 26
        for c in target:
            t[ord(c) - ord('a')] += 1
        ans = 100
        for i, v in enumerate(t):
            if not v:
                continue
            ans = min(ans, cnt[i] // v)
        return ans