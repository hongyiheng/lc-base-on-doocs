class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        def decr(idx, arr):
            nonlocal n
            ans = 0
            if idx < n - 1 and arr[idx] >= arr[idx + 1]:
                ans += arr[idx] - arr[idx + 1] + 1
                arr[idx] = arr[idx + 1] - 1
            if idx > 0 and arr[idx] >= arr[idx - 1]:
                ans += arr[idx] - arr[idx - 1] + 1
                arr[idx] = arr[idx - 1] - 1
            return ans

        idx, n, ans, ans2 = 0, len(nums), 0, 0
        nums2 = nums[::]
        while idx < n:
            if idx % 2 == 0:
                ans += decr(idx, nums)
            else:
                ans2 += decr(idx, nums2)
            idx += 1
        return min(ans, ans2)
