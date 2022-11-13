class Solution:
    def customSortString(self, order: str, s: str) -> str:
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        n = len(s)
        ans = list()
        for c in order:
            while cnt[ord(c) - ord('a')] > 0:
                cnt[ord(c) - ord('a')] -= 1
                ans.append(c)
        for i in range(26):
            while cnt[i] > 0:
                ans.append(chr(ord('a') + i))
                cnt[i] -= 1
        return "".join(ans)
