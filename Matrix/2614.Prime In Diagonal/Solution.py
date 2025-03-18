class Solution:
    def diagonalPrime(self, nums: List[List[int]]) -> int:
        def is_prime(v):
            for i in range(2, int(math.sqrt(v)) + 1):
                if v % i == 0:
                    return False
            return v >= 2

        ans = 0
        for i, row in enumerate(nums):
            for v in [row[i], row[-i - 1]]:
                if v > ans and is_prime(v):
                    ans = v
        return ans