class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        cnt = [0] * 110
        for num in nums:
            cnt[num] += 1
        ans = 0
        for i in range(110):
            if cnt[i] == 1:
                ans += i
        return ans