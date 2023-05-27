class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        mod_mx = mod = 0
        mi, mx = 255, 0
        cnt = val = 0
        for i, v in enumerate(count):
            if v:
                cnt += v
                val += i * v
                mi = min(mi, i)
                mx = max(mx, i)
                if v > mod_mx:
                    mod = i
                    mod_mx = v
        mean = val / cnt
        cur = median = 0
        for i, v in enumerate(count):
            cur += v
            if cnt % 2:
                if cur > cnt // 2:
                    median = i
                    break
            else:
                if median == 0 and cur >= cnt // 2:
                    median = i
                if cur >= cnt // 2 + 1:
                    median += i
                    median /= 2
                    break
        return [mi, mx, mean, median, mod]
