class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        n = len(arr)
        ans = 0
        for j in range(n):
            s = 0
            for k in range(j, n):
                s ^= arr[k]
                if s == 0:
                    ans += k - j
        return ans