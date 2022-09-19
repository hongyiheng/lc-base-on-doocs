class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        cnt = [0] * 5010
        for v in nums:
            cnt[v] += 1
        idx, n, j = 0, len(nums), 5000
        for i in range(1, n, 2):
            while cnt[j] == 0:
                j -= 1
            nums[i] = j
            cnt[j] -= 1
        for i in range(0, n, 2):
            while cnt[j] == 0:
                j -= 1
            nums[i] = j
            cnt[j] -= 1