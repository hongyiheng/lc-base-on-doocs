class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        arr = [0] * 201
        n = len(nums)
        for i in range(n):
            index = nums[i] + 100
            arr[index] += 1
        for i in range(k):
            for j in range(201):
                if arr[j]:
                    arr[j] -= 1
                    index = -1 * (j - 100) + 100
                    arr[index] += 1
                    break
        res = 0
        for i in range(201):
            res += arr[i] * (i - 100)
        return res