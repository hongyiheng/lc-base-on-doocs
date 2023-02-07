class Solution:
    def alertNames(self, keyName: List[str], keyTime: List[str]) -> List[str]:
        t = [list() for _ in range(24 * 60)]
        for name, time in zip(keyName, keyTime):
            m = int(time[:2]) * 60 + int(time[3:])
            t[m].append(name)
        cnt = defaultdict(int)
        ans = list()
        l = r = 0
        while r < 24 * 60:
            if r - l > 60:
                for name in t[l]:
                    cnt[name] -= 1
                l += 1
            for name in t[r]:
                cnt[name] += 1
                if cnt[name] >= 3:
                    ans.append(name)
                    cnt[name] = -0x3f3f3f3f
            r += 1
        ans.sort()
        return ans
