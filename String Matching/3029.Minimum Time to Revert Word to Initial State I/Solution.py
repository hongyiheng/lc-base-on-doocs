class Solution:
    def minimumTimeToInitialState(self, word: str, k: int) -> int:
        ans, n = 0, len(word)
        for i in range(k, n, k):
            ans += 1
            s = word[i:]
            if s == word[:len(s)]:
                return ans
        return ans + 1