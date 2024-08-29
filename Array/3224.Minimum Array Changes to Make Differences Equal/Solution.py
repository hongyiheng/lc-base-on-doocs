class Solution:
    def minChanges(self, nums: List[int], k: int) -> int:
        n = len(nums)
        q = []
        freq = defaultdict(int)
        for i in range(n):
            r = n - i - 1
            if i >= r:
                break
            x = abs(nums[r] - nums[i])
            q.append(x)
            freq[x] += 1

        kvs = [[k, freq[k]] for k in freq.keys()]
        kvs.sort(key=lambda x: (-x[1], x[0]))
        ans = n
        for t, f in kvs:
            if ans <= len(q) - f:
                break
            cnt = 0
            for i, v in enumerate(q):
                if v == t:
                    continue
                r = n - i - 1
                if max(nums[i] - k, 0) <= t <= max(nums[i], k - nums[i]) or max(nums[r] - k, 0) <= t <= max(nums[r], k - nums[r]):
                    cnt += 1
                elif k >= t:
                    cnt += 2
                else:
                    cnt = n
                    break
            ans = min(ans, cnt)
        return ans
