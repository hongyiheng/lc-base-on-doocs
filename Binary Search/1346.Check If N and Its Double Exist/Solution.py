class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        arr.sort()
        n = len(arr)
        for i, v in enumerate(arr):
            left, right = 0, n - 1
            while left < right:
                mid = (left + right) >> 1
                if arr[mid] < 2 * v:
                    left = mid + 1
                else:
                    right = mid
            if left < n and left != i and arr[left] == 2 * v:
                return True
        return False