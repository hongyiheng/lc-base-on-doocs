class Solution:
    def magicalString(self, n: int) -> int:
        ans, cur = 0, 2
        nums = [1, 2, 2] + [0] * n
        for i in range(n):
            if nums[i] == 0:
                v = 2 if nums[i - 1] == 1 else 1
                nums[i] = v
                if nums[cur] == 2:
                    nums[i + 1] = v
                cur += 1
            if nums[i] == 1:
                ans += 1
        return ans
