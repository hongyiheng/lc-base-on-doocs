class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        g = defaultdict(list)
        for i, v in enumerate(nums):
            g[v].append(i)
        ans = [0] * len(nums)
        for arr in g.values():
            m = len(arr)
            s = [0] * (m + 1)
            for i in range(m):
                s[i + 1] = s[i] + arr[i]
            for i, v in enumerate(arr):
                l = i * v - s[i]
                r = s[m] - s[i] - v * (m - i)
                ans[v] = l + r
        return ans

