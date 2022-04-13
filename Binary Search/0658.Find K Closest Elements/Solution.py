class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        def check(a, b):
            nonlocal x
            return abs(a - x) < abs(b - x) or (abs(a - x) == abs(b - x) and a < b)

        n = len(arr)
        if k >= n:
            return arr
        left, right = 0, n - 1
        while left < right:
            mid = (left + right) >> 1
            if arr[mid] < x:
                left = mid + 1
            else:
                right = mid
        if left > 0 and check(arr[left - 1], arr[left]):
            left = left - 1
        a, b = left, left
        k -= 1
        while k > 0:
            if a > 0 and b < n - 1:
                if check(arr[a - 1], arr[b + 1]):
                    a -= 1
                else:
                    b += 1
            elif a > 0:
                a -= 1
            else:
                b += 1
            k -= 1
        return arr[a:b + 1]