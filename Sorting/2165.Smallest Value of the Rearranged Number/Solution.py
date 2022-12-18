class Solution:
    def smallestNumber(self, num: int) -> int:
        s = str(num)
        ne = False
        if s[0] == '-':
            ne = True
            s = s[1:]
        cnt = [0] * 10
        for v in s:
            cnt[ord(v) - ord('0')] += 1
        ans = 0
        if ne:
            for i in range(9, -1, -1):
                while cnt[i]:
                    ans = ans * 10 + i
                    cnt[i] -= 1
        else:
            for i in range(1, 10):
                if cnt[i]:
                    ans = i
                    cnt[i] -= 1
                    break
            for i in range(10):
                while cnt[i]:
                    ans = ans * 10 + i
                    cnt[i] -= 1
        return -ans if ne else ans