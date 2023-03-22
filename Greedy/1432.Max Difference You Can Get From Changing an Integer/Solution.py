class Solution:
    def maxDiff(self, num: int) -> int:
        s = str(num)
        n = len(s)
        for i in range(n):
            if s[i] != '9':
                s = s.replace(s[i], '9')
                break
        mx = int(s)
        s = str(num)
        for i in range(n):
            if i == 0 and s[i] !='1':
                s = s.replace(s[i], '1')
                break
            if i != 0 and s[i] != '0' and s[i] != s[0]:
                s = s.replace(s[i], '0')
                break
        mi = int(s)
        return mx - mi