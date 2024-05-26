class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        n = len(nums)
        even = [nums[i] for i in range(0, n, 2)]
        odd = [nums[i] for i in range(1, n, 2)]
        even.sort()
        odd.sort(reverse=True)
        for i in range(n):
            if not i & 1:
                nums[i] = even[i // 2]
            else:
                nums[i] = odd[(i - 1) // 2]
        return nums