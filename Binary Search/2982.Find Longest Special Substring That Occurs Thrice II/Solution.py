class Solution:
    def maximumLength(self, s: str) -> int:
        def check(x):
            cnt = [0] * 26
            i = 0
            while i < len(s):
                j = i + 1
                while j < len(s) and s[i] == s[j]:
                    j += 1
                v = ord(s[i]) - ord('a')
                cnt[v] += max(0, j - i - x + 1 if x else j - i - x)
                if cnt[v] >= 3:
                    return True
                i = j
            return False

        l, r = 0, len(s) - 2
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r if check(r) else -1