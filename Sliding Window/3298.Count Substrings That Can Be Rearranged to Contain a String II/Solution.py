class Solution:
    def validSubstringCount(self, word1: str, word2: str) -> int:
        def check():
            for a, b in zip(cnt, t):
                if a < b:
                    return False
            return True

        t = [0] * 26
        for c in word2:
            t[ord(c) - ord('a')] += 1
        cnt = [0] * 26
        n = len(word1)
        l = r = ans = 0
        while r < n:
            v = ord(word1[r]) - ord('a')
            cnt[v] += 1
            while cnt[v] >= t[v] and check():
                ans += n - r
                cnt[ord(word1[l]) - ord('a')] -= 1
                l += 1
            r += 1
        return ans
        