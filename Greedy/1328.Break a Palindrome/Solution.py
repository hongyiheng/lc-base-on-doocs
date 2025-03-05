class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        def check():
            l, r = 0, len(cs) - 1
            while l < r:
                if cs[l] != cs[r]:
                    return False
                l += 1
                r -= 1
            return True

        if len(palindrome) == 1:
            return ""
        cs = list(palindrome)
        for i, c in enumerate(cs):
            for t in range(ord(c) - ord('a')):
                cs[i] = chr(t + ord('a'))
                if not check():
                    return "".join(cs)
                cs[i] = palindrome[i]
        cs[-1] = 'b'
        return "".join(cs)