class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        def check(k):
            for i in range(k):
                if 2 * nums[i] > nums[-k + i]:
                    return False
            return True

        nums.sort()
        l, r = 0, len(nums) // 2
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return l * 2