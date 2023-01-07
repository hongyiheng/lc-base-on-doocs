class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        n = len(word)
        if n == 1:
            return True
        if "a" <= word[0] <= "z":
            for c in word:
                if "a" <= c <= "z":
                    continue
                return False
        elif "a" <= word[1] <= "z":
            for i in range(1, n):
                if "a" <= word[i] <= "z":
                    continue
                return False
        else:
            for c in word:
                if "A" <= c <= "Z":
                    continue
                return False
        return True