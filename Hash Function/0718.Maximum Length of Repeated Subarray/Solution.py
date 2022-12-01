class Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:
        base, mod = 113, int(1e9 + 7)

        def get_hash_set(arr, k):
            h = 0
            for i in range(k):
                h = (h * base + arr[i]) % mod
            ans = {h}
            mult = pow(base, k - 1, mod)
            for i in range(k, len(arr)):
                h = ((h - arr[i - k] * mult) * base + arr[i]) % mod
                ans.add(h)
            return ans

        def check(k):
            s1 = get_hash_set(A, k)
            s2 = get_hash_set(B, k)
            return len(s1 & s2) > 0

        left, right = 0, min(len(A), len(B))
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left
