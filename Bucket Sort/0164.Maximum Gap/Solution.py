class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2:
            return 0
        max_, min_ = max(nums), min(nums)
        bucket_len = max(1, (max_ - min_) // (n - 1))
        bucket = [None] * ((max_ - min_) // bucket_len + 1)
        for v in nums:
            idx = (v - min_) // bucket_len
            if bucket[idx] is None:
                bucket[idx] = []
            bucket[idx].append(v)
        ans, last = 0, float('inf')
        for b in bucket:
            if b:
                b_max = max(b)
                b_min = min(b)
                ans = max(ans, b_max - b_min)
                if last != float('inf'):
                    ans = max(ans, b_min - last)
                last = b_max
        return ans