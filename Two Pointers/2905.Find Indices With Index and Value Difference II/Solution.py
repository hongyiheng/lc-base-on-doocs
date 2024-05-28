class Solution:
    def findIndices(self, nums: List[int], indexDifference: int, valueDifference: int) -> List[int]:
        mi = mx = nums[0]
        mi_idx = mx_idx = 0
        for i in range(indexDifference, len(nums)):
            v, l = nums[i], i - indexDifference
            if i >= indexDifference:
                if nums[l] < mi:
                    mi = nums[l]
                    mi_idx = l
                if nums[l] > mx:
                    mx = nums[l]
                    mx_idx = l
            if abs(v - mi) >= valueDifference:
                return [mi_idx, i]
            if abs(v - mx) >= valueDifference:
                return [mx_idx, i]
        return [-1, -1]