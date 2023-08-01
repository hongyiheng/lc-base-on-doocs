class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        rk = [(k, cnt.get(k)) for k in cnt.keys()]
        rk.sort(key=lambda x:-x[1])
        if len(rk) >= 2 and rk[0][1] == rk[1][1]:
            return -1
        n = len(nums)
        x, s = rk[0]
        cur = 0
        for i, v in enumerate(nums):
            if v == x:
                cur += 1
            if cur * 2 > i + 1 and (s - cur) * 2 > n - i - 1:
                return i
        return -1