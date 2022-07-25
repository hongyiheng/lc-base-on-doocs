class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        def sort(nums, tmp, left, right):
            if left >= right:
                return
            mid = (left + right) >> 1
            sort(nums, tmp, left, mid)
            sort(nums, tmp, mid + 1, right)
            merge(nums, tmp, left, right, mid)

        def merge(nums, tmp, left, right, mid):
            nonlocal ans
            l, r, t = left, mid + 1, left
            while l <= mid and r <= right:
                if nums[l] <= 2 * nums[r]:
                    l += 1
                else:
                    ans += mid - l + 1
                    r += 1
            l, r, t = left, mid + 1, left
            while l <= mid or r <= right:
                if r > right or (l <= mid and nums[l] <= nums[r]):
                    tmp[t] = nums[l]
                    l += 1
                else:
                    tmp[t] = nums[r]
                    r += 1
                t += 1
            for i in range(left, right + 1):
                nums[i] = tmp[i]

        n = len(nums)
        tmp = [0] * n
        ans = 0
        sort(nums, tmp, 0, n - 1)
        return ans