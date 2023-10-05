class Solution:
    def minMaxDifference(self, num: int) -> int:
        s = str(num)
        mx = num
        for c in s:
            if c != '9':
                mx = int(str(num).replace(c, '9'))
                break
        s = s.replace(s[0], '0')
        return mx - int(s)
