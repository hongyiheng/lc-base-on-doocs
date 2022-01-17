class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.mp = defaultdict(list)
        for i, v in enumerate(wordsDict):
            self.mp[hash(v)].append(i)


    def shortest(self, word1: str, word2: str) -> int:
        index1, index2 = self.mp[hash(word1)], self.mp[hash(word2)]
        ans = float('inf')
        for i in index1:
            for j in index2:
                ans = min(ans, abs(i - j))
        return ans



# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)