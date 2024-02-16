class Solution:
    def maximumLength(self, s: str) -> int:
        def check(x):
            for q in cnt.values():
                k = 0
                for v in q:
                    if v < x:
                        continue
                    k += v - x + 1
                if k >= 3:
                    return True
            return False

        cnt = defaultdict(list)
        last_v = last_len = 0
        for c in s:
            v = ord(c) - ord('a')
            if v == last_v:
                last_len += 1
            else:
                cnt[last_v].append(last_len)
                last_len = 1
            last_v = v
        cnt[last_v].append(last_len)

        l, r = 0, len(s)
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r if r > 0 else -1

