class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        n = len(numbers)
        for i, v in enumerate(numbers):
            t = target - v
            l, r = i + 1, n - 1
            while l < r:
                mid = (l + r) >> 1
                if numbers[mid] < t:
                    l = mid + 1
                else:
                    r = mid
            if numbers[r] == t:
                return [i + 1, r + 1]
        return []