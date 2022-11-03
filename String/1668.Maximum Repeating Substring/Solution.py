class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        ori = word
        ans = 0
        while word in sequence:
            word += ori
            ans += 1
        return ans
