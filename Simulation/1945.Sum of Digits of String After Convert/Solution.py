class Solution:
    def getLucky(self, s: str, k: int) -> int:
        ss = ""
        for c in s:
            ss += str(ord(c) - ord('a') + 1)
        ans = 0
        while k > 0:
            cur = 0
            for c in ss:
                cur += ord(c) - ord('0')
            ans = cur
            ss = str(cur)
            k -= 1
        return ans

