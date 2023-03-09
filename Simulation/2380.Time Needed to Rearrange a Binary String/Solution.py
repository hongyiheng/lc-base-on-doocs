class Solution:
    def secondsToRemoveOccurrences(self, s: str) -> int:
        n, ans = len(s), 0
        cs = list(s)
        while s.find('01') != -1:
            ans += 1
            i = 0
            while i < n - 1:
                if cs[i] == '0' and cs[i + 1] == '1':
                    cs[i] = '1'
                    cs[i + 1] = '0'
                    i += 2
                else:
                    i += 1
            s = "".join(cs)
        return ans