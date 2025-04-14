class Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        n = len(arr)
        ans = 0
        for i in range(n):
            for k in range(i + 2, n):
                if abs(arr[i] - arr[k]) > c:
                    continue
                for j in range(i + 1, k):
                    if abs(arr[i] - arr[j]) > a or abs(arr[j] - arr[k]) > b:
                        continue
                    ans += 1
        return ans
