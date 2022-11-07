class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        s = [False] * 26
        for c in allowed:
            s[ord(c) - ord('a')] = True
        ans = 0
        for w in words:
            same = True
            for c in w:
                if not s[ord(c) - ord('a')]:
                    same = False
                    break
            ans += same
        return ans
