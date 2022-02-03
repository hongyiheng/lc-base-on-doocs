class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        nums = [1]
        a, b = 1, 1
        while b < k:
            c = a + b
            nums.append(c)
            a = b
            b = c

        def find_smaller():
            left, right = 0, len(nums) - 1
            while left < right:
                mid = (left + right + 1) >> 1
                if nums[mid] <= k:
                    left = mid
                else:
                    right = mid - 1
            return nums[left]

        ans = 0
        while k > 0:
            k -= find_smaller()
            ans += 1
        return ans
