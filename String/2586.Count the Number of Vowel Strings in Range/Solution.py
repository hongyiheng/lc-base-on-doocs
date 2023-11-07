class Solution:
    def vowelStrings(self, words: List[str], left: int, right: int) -> int:
        ans = 0
        s = {'a', 'e', 'i', 'o', 'u'}
        for i in range(left, right + 1):
            if words[i][0] in s and words[i][-1] in s:
                ans += 1
        return ans