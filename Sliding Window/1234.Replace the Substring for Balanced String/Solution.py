class Solution:
    def balancedString(self, s: str) -> int:
        def check(cnt, cur):
            nonlocal t
            ans = True
            for a, b in zip(cnt, cur):
                ans = ans and (a - t <= 0 or b >= a - t)
            return ans

        mp = {'Q': 0, 'W':1, 'E':2, 'R': 3}
        n, t = len(s), len(s) // 4
        cnt = [0] * 4
        for c in s:
            cnt[mp[c]] += 1
        cur = [0] * 4
        if check(cnt, cur):
            return 0
        ans = 0x3f3f3f3f
        l = r = 0
        while r < n:
            cur[mp[s[r]]] += 1
            while l <= r and check(cnt, cur):
                ans = min(ans, r - l + 1)
                cur[mp[s[l]]] -= 1
                l += 1
            r += 1
        check(cnt, cur)
        return ans