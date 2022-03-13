class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        n = len(s)
        if n <= 2:
            return n
        mp = dict()
        left = right = 0
        win = 2
        while right < n:
            mp[s[right]] = right
            if len(mp) >= 3:
                del_val = min(mp.values())
                mp.pop(s[del_val])
                win = max(win, right - left)
                left = del_val + 1
            right += 1
        win = max(win, right - left)
        return win