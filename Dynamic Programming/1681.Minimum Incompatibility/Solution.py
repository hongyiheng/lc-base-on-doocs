class Solution:
    def minimumIncompatibility(self, nums: List[int], k: int) -> int:
        def get_next(mask):
            for i in range(n):
                if mask >> i & 1 == 0:
                    return i

        @cache
        def dfs(mask, idx):
            if mask == (1 << n) - 1:
                return 0
            if mask.bit_count() % t == 0:
                i = get_next(mask)
                return dfs(mask | 1 << i, i)
            ans = inf
            last = nums[idx]
            for i in range(idx + 1, n):
                if nums[i] == last or mask >> i & 1:
                    continue
                last = nums[i]
                ans = min(ans, last - nums[idx] + dfs(mask | 1 << i, i))
            return ans

        cnt = Counter(nums)
        if max(cnt.values()) > k:
            return -1
        n = len(nums)
        t = n // k
        nums.sort()
        return dfs(0, 0)