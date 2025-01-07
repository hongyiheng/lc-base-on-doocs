class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        if k == 1:
            return True
        n, cnt = len(nums), 1
        f = [False] * n
        for i in range(1, n):
            if nums[i - 1] < nums[i]:
                cnt += 1
            else:
                cnt = 1
            if cnt >= k:
                f[i] = True
                if f[i - k]:
                    return True
        return False