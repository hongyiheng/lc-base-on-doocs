class Solution:
    def splitWordsBySeparator(self, words: List[str], separator: str) -> List[str]:
        ans = []
        for w in words:
            ans.extend([s for s in w.split(separator) if s])
        return ans