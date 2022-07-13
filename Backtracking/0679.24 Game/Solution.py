class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        ans = False
        diff = 1e-6

        def fill_array(nums, new_nums, i, j):
            idx = 0
            for k in range(1, len(new_nums)):
                while idx == i or idx == j:
                    idx += 1
                new_nums[k] = nums[idx]
                idx += 1

        def dfs(nums):
            nonlocal ans
            if ans:
                return
            n = len(nums)
            if n == 1:
                if abs(nums[0] - 24) < diff:
                    ans = True
                    return
            for i in range(n):
                for j in range(n):
                    if i == j:
                        continue
                    new_nums = [0] * (n - 1)
                    new_nums[0] = nums[i] + nums[j]
                    fill_array(nums, new_nums, i, j)
                    dfs(new_nums)
                    new_nums[0] = nums[i] - nums[j]
                    fill_array(nums, new_nums, i, j)
                    dfs(new_nums)
                    new_nums[0] = nums[i] * nums[j]
                    fill_array(nums, new_nums, i, j)
                    dfs(new_nums)
                    if nums[j]:
                        new_nums[0] = nums[i] / nums[j]
                        fill_array(nums, new_nums, i, j)
                        dfs(new_nums)

        dfs(cards)
        return ans