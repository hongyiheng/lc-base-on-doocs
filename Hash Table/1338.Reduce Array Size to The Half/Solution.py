class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        cnt = Counter(arr)
        vals = [v for v in cnt.values()]
        vals.sort(reverse=True)
        ans = cur = 0
        for v in vals:
            if cur >= len(arr) / 2:
                break
            cur += v
            ans += 1
        return ans