class Solution:
    def maxDivScore(self, nums: List[int], divisors: List[int]) -> int:
        mx, ans = 0, divisors[0]
        for d in divisors:
            cnt = 0
            for v in nums:
                if not v % d:
                    cnt += 1
            if cnt > mx or (cnt == mx and ans > d):
                ans = d
                mx = cnt
        return ans