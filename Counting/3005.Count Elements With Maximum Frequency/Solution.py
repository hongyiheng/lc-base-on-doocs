class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        cnt = [0] * 26
        for c in word:
            cnt[ord(c) - ord('a')] += 1
        ans = n = len(word)
        for x in cnt:
            c = 0
            for v in cnt:
                if v >= x:
                    c += min(x + k, v)
            ans = min(ans, n - c)
        return ans
