class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        ans = 0
        for v in nums:
            t = int(math.sqrt(v))
            q = []
            for i in range(2, t + 1):
                if v == t * t:
                    break
                if v % i == 0:
                    q.append(i)
                if len(q) > 1:
                    break
            if len(q) == 1:
                ans += 1 + v + q[0] + v // q[0]
        return ans