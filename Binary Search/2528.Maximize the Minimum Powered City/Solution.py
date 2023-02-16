class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        def check(arr, r, t, k):
            nonlocal n
            cur = sum(arr[:r + 1])
            left, right = 0, r
            for _ in range(n):
                if cur < t:
                    if t - cur > k:
                        return False
                    arr[min(right, n - 1)] += (t - cur)
                    k -= (t - cur)
                    cur = t
                right += 1
                if right < n:
                    cur += arr[right]
                if right - left + 1 > 2 * r + 1:
                    cur -= arr[left]
                    left += 1
            return True

        n = len(stations)
        left, right = 0, 0x3f3f3f3f3f3f
        while left < right:
            mid = (left + right + 1) >> 1
            if check(stations[::], r, mid, k):
                left = mid
            else:
                right = mid - 1
        return left