class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        cnt = [-1] * 26
        for s in words:
            cur = [0] * 26
            for c in s:
                cur[ord(c) - ord('a')] += 1
            for i in range(26):
                if cnt[i] == -1 or cnt[i] == cur[i]:
                    cnt[i] = cur[i]
                else:
                    cnt[i] = min(cnt[i], cur[i])
        ans = []
        for i in range(26):
            while cnt[i] > 0:
                ans.append(str(chr(ord('a') + i)))
                cnt[i] -= 1
        return ans

