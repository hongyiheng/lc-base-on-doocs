class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        n = len(s)
        if n <= 2:
            return s
        cnt, last = 0, 0
        q = []
        for i in range(n):
            cnt += 1 if s[i] == '1' else -1
            if cnt == 0:
                q.append('1' + self.makeLargestSpecial(s[last + 1: i]) + '0')
                last = i + 1
        q.sort(reverse=True)
        return "".join(q)
