class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        mp, cur = [0] * 26, [0] * 26
        n = len(p)
        for i in range(len(p)):
            index = ord(p[i]) - ord('a')
            mp[index] += 1

        def check():
            for i in range(26):
                if mp[i] != cur[i]:
                    return False
            return True

        l, res = 0, list()
        for r in range(0, len(s)):
            index = ord(s[r]) - ord('a')
            cur[index] += 1
            if r - l == n:
                cur[ord(s[l]) -ord('a')] -= 1
                l += 1
            if check():
                res.append(l)
        return res