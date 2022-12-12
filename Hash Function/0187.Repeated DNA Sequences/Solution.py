class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        b, p = 131313, 131313 ** 9
        n = len(s)
        ans = list()
        mp = dict()
        l = r = cur = 0
        while r < n:
            cur = cur * b + ord(s[r])
            if r - l + 1 == 10:
                v = mp.get(cur, 0)
                if v == 1:
                    ans.append(s[l:r + 1])
                    mp[cur] += 1
                mp[cur] = v + 1
                cur -= ord(s[l]) * p
                l += 1
            r += 1
        return list(ans)
