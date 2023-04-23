class Solution:
    def getStrongest(self, arr: List[int], k: int) -> List[int]:
        n = len(arr)
        arr.sort()
        mid = arr[(n - 1) // 2]
        l, r = 0, n - 1
        ans = []
        while k:
            if abs(arr[r] - mid) >= abs(arr[l] - mid):
                ans.append(arr[r])
                r -= 1
            else:
                ans.append(arr[l])
                l += 1
            k -= 1
        return ans
