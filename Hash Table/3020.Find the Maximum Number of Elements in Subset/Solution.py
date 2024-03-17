class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        cnt = defaultdict(int)
        for v in nums:
            cnt[v] += 1
        nums.sort()
        ans = 1
        vis = set()
        for v in nums:
            if cnt[v] < 2 or v == 1 or v in vis:
                continue
            x = v
            d = 1
            while cnt[x * x] >= 2:
                vis.add(x)
                d += 1
                x = x * x
            d = d * 2 + (1 if cnt[x * x] else -1)
            ans = max(ans, d)
        if cnt[1]:
            ans = max(ans, cnt[1] // 2 * 2 + (1 if cnt[1] % 2 else -1))
        return ans