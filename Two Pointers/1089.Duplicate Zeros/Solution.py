class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        n = len(arr)
        ans = [0] * n
        cnt = 0
        for i in range(n):
            if arr[i] == 0:
                cnt += 1
            elif i + cnt < n:
                ans[i + cnt] = arr[i]
        for i in range(n):
            arr[i] = ans[i]