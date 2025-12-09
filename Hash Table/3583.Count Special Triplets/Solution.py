class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        mod = int(1e9 + 7)
        g = defaultdict(list)
        for i, v in enumerate(nums):
            g[v].append(i)
        ans = 0
        for i, v in enumerate(nums):
            if len(g[v * 2]) < 2:
                continue
            arr = g[v * 2]
            pos = bisect.bisect_left(arr, i)
            if not pos or pos == len(arr):
                continue
            l = pos if arr[pos] != i else pos - 1
            r = len(arr) - pos
            ans += l * r % mod
        return ans % mod

