class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        ans = 0
        for w in text.split(" "):
            broken = False
            for c in w:
                if c in brokenLetters:
                    broken = True
                    break
            if not broken:
                ans += 1
        return ans
