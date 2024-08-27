class Solution:
    def medianOfUniquenessArray(self, nums: List[int]) -> int:
        def check(x):
            nonlocal k, n
            l = r = s = 0
            cnt = defaultdict(int)
            while r < n:
                cnt[nums[r]] += 1
                while len(cnt) > x:
                    cnt[nums[l]] -= 1
                    if cnt[nums[l]] == 0:
                        cnt.pop(nums[l])
                    l += 1
                s += r - l + 1
                if s >= k:
                    return True
                r += 1
            return False

        n = len(nums)
        k = ((1 + n) * n / 2 + 1) // 2
        l, r = 1, 10 ** 5
        while l < r:
            mid = (l + r) >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r



