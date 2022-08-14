class Solution:
    def repeatedCharacter(self, s: str) -> str:
        cs = [False] * 26
        for c in list(s):
            idx = ord(c)- ord('a')
            if cs[idx]:
                return c
            else:
                cs[idx] = True
        return ""