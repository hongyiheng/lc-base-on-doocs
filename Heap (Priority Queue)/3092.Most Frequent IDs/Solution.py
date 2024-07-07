class Solution:
    def mostFrequentIDs(self, nums: List[int], freq: List[int]) -> List[int]:
        rk, ans = [], []
        cnt = defaultdict(int)
        for a, b in zip(nums, freq):
            cnt[a] += b
            heapq.heappush(rk, (-cnt[a], a))
            while rk[0][0] != -cnt[rk[0][1]]:
                heapq.heappop(rk)
            ans.append(-rk[0][0])
        return ans