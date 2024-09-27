class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        def check(x):
            cnt = [0] * 3
            l = 0
            for i, v in enumerate(s):
                cnt[ord(v) - ord('a')] += 1
                if i - l + 1 == x:
                    hit = True
                    for a, b in zip(t, cnt):
                        if a < b:
                            hit = False
                    if hit:
                        return True
                    cnt[ord(s[l]) - ord('a')] -= 1
                    l += 1
            return False

        if k == 0:
            return 0
        q, t = [0] * 3, [-k] * 3
        for c in s:
            pos = ord(c) - ord('a')
            q[pos] += 1
            t[pos] += 1
        for v in t:
            if v < 0:
                return -1
        l, r = 0, len(s) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return len(s) - r
