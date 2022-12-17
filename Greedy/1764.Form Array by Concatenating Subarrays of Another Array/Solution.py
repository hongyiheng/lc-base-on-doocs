class Solution:
    def canChoose(self, groups: List[List[int]], nums: List[int]) -> bool:
        m, n = len(groups), len(nums)
        i = j = 0
        while j < n:
            if i >= m:
                break
            if j + len(groups[i]) <= n and groups[i] == nums[j:j + len(groups[i])]:
                j += len(groups[i])
                i += 1
            else:
                j += 1
        return i == m
