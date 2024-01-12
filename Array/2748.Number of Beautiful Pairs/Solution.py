class Solution:
    def countBeautifulPairs(self, nums: List[int]) -> int:
        ans, n = 0, len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                if gcd(int(str(nums[i])[0]), int(str(nums[j])[-1])) == 1:
                    ans += 1
        return ans
