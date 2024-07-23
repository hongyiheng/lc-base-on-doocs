class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        ans, n = 0, len(words)
        for i in range(n):
            m = len(words[i])
            for j in range(i + 1, n):
                if len(words[j]) < m:
                    continue
                if words[j][:m] == words[j][-m:] == words[i]:
                    ans += 1
        return ans