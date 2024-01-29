class Solution:
    def findWordsContaining(self, words: List[str], x: str) -> List[int]:
        ans = []
        for i, w in enumerate(words):
            for c in w:
                if c == x:
                    ans.append(i)
                    break
        return ans