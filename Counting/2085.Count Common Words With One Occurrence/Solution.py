class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        g1, g2 = Counter(words1), Counter(words2)
        ans = 0
        for k in g1.keys():
            if g1[k] == 1 and g2.get(k, 0) == 1:
                ans += 1
        return ans