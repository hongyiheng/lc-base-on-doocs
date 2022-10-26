class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        mp = dict()
        ans = float('inf')
        for i, v in enumerate(wordsDict):
            if v != word1 and v != word2:
                continue
            if v == word1:
                if word2 in mp:
                    ans = min(ans, i - mp[word2])
            else:
                if word1 in mp:
                    ans = min(ans, i - mp[word1])
            mp[v] = i
        return ans
