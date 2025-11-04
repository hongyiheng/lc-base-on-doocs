class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        n = len(nums)
        ans = []
        if n < k:
            return sum(nums)
        for i in range(n - k + 1):
            cnt = Counter(nums[i:i+k])
            q = sorted(cnt.items(), key = lambda e:(-e[1], -e[0]))
            top_x = [v[0] for v in q[:x]]
            ans.append(sum(i * cnt[i] for i in top_x))
        return ans
