class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        mp = dict()
        ans = -1
        for i, c in enumerate(s):
            if c in mp:
                ans = max(i - mp.get(c) - 1, ans)
            else:
                mp[c] = i
        return ans