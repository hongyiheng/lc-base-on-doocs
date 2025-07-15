class Solution:
    def isValid(self, word: str) -> bool:
        if len(word) < 3:
            return False
        vs = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'}
        v = c = False
        for x in word:
            if '0' <= x <= '9':
                continue
            elif x in vs:
                v = True
            elif 'a' <= x <= 'z' or 'A' <= x <= 'Z':
                c = True
            else:
                return False
        return v and c



