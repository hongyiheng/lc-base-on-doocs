class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        t = len(arr) // 4
        for i in range(t, len(arr)):
            if arr[i] == arr[i - t]:
                return arr[i]
        return -1

