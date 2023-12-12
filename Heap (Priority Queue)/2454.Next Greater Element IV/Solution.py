class Solution:
    def secondGreaterElement(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        q = []
        for i in range(n):
            tmp = []
            while q and q[0][0] < nums[i]:
                tmp.append(heapq.heappop(q))
                tmp[-1][2] -= 1
            for v, j, k in tmp:
                if not k:
                    ans[j] = nums[i]
                else:
                    heapq.heappush(q, [v, j, k])
            heapq.heappush(q, [nums[i], i, 2])
        return ans