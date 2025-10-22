class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        cnt = defaultdict(int)
        for v in nums:
            cnt[v] += 1
            if v - k not in cnt:
                cnt[v - k] = 0
            if v + k not in cnt:
                cnt[v + k] = 0
        if k == 0:
            return max(cnt.values())
        ks = sorted(cnt.keys())
        ans = l = r = 0
        s = cnt[ks[0]]
        for i in range(len(ks)):
            while ks[l] + k < ks[i]:
                s -= cnt[ks[l]]
                l += 1
            while r + 1 < len(ks) and ks[r + 1] <= ks[i] + k:
                s += cnt[ks[r + 1]]
                r += 1
            ans = max(ans, min(s - cnt[ks[i]], numOperations) + cnt[ks[i]])
        return ans