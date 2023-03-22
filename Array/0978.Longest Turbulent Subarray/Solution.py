class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        if not arr:
            return 0
        ans = cnt = 1
        for i in range(1, len(arr)):
            if i % 2 == 0 and arr[i] > arr[i - 1] or (i % 2 and arr[i] < arr[i - 1]):
                cnt += 1
            else:
                ans = max(ans, cnt)
                cnt = 1
        ans = max(ans, cnt)
        cnt = 1
        for i in range(1, len(arr)):
            if i % 2 == 1 and arr[i] > arr[i - 1] or (i % 2 == 0 and arr[i] < arr[i - 1]):
                cnt += 1
            else:
                ans = max(ans, cnt)
                cnt = 1
        return max(ans, cnt)