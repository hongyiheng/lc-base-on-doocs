class Solution:
    def sortVowels(self, s: str) -> str:
        vs = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        vowels = []
        for c in s:
            if c in vs:
                vowels.append(c)
        vowels.sort()
        j = 0
        cs = list(s)
        for i, c in enumerate(cs):
            if c in vs:
                cs[i] = vowels[j]
                j += 1
        return "".join(cs)