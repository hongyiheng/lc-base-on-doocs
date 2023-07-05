class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        M = 1010
        primes = [False] * M
        for i in range(2, M):
            if not primes[i]:
                for j in range(i * i, M, i):
                    primes[j] = True
        q = []
        for i in range(2, M):
            if not primes[i]:
                q.append(i)

        n = len(nums)
        for i in range(n - 2, -1, -1):
            if nums[i] >= nums[i + 1]:
                t = nums[i] - nums[i + 1]
                l, r = 0, len(q) - 1
                while l < r:
                    mid = (l + r) >> 1
                    if q[mid] <= t:
                        l = mid + 1
                    else:
                        r = mid
                if q[l] > t and q[l] < nums[i]:
                    nums[i] -= q[l]
                else:
                    return False
        return True