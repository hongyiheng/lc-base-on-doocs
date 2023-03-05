class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        cur = 0
        ans = []
        for c in word:
            cur = (cur * 10 + int(c)) % m
            ans.append(0 if cur else 1)
        return ans