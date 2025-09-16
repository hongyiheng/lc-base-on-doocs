class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        q = []
        for x in nums:
            while q and gcd(x, q[-1]) > 1:
                x = lcm(x, q.pop())
            q.append(x)
        return q