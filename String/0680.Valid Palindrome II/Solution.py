class Solution:
    def validPalindrome(self, s: str) -> bool:
        def dfs(t, skip):
            if len(t) <= 1:
                return True
            if not skip and len(t) <= 2:
                return True
            if t[0] != t[-1]:
                if skip:
                    return False
                return dfs(t[1:], True) or dfs(t[:-1], True)
            return dfs(t[1:-1], skip)
        
        return dfs(s, False)
        
