class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
        for w in words:
            l, r = 0, len(w) - 1
            while l < r:
                if w[l] != w[r]:
                    break
                l += 1
                r -= 1
            if l >= r:
                return w
        return ""
