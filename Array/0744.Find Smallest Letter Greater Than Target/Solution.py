class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        ans = None
        for c in letters:
            if c > target and (not ans or c < ans):
                ans = c
        return letters[0] if not ans else ans