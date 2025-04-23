class Solution:
    def countLargestGroup(self, n: int) -> int:
        cnt = defaultdict(int)
        for v in range(1, n + 1):
            s = 0
            while v:
                s += v % 10
                v //= 10
            cnt[s] += 1
        mx = 0
        group = defaultdict(int)
        for k in cnt.keys():
            group[cnt[k]] += 1
            mx = max(mx, cnt[k])
        return group[mx]
        