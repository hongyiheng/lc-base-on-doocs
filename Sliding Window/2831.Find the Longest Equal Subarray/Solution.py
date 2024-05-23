class Solution:
    def longestEqualSubarray(self, nums: List[int], k: int) -> int:
        def get_mx():
            while rk and -rk[0][0] != cnt[rk[0][1]]:
                heapq.heappop(rk)
            return -rk[0][0]

        rk = []
        cnt = defaultdict(int)
        l = -1
        ans = 0
        for i, v in enumerate(nums):
            cnt[v] += 1
            heapq.heappush(rk, (-cnt[v], v))
            while i - l - get_mx() > k:
                l += 1
                cnt[nums[l]] -= 1
            ans = max(ans, get_mx())
        return ans