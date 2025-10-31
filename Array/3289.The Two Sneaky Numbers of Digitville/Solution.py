class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        cnt = Counter(nums)
        return sorted([k for k in cnt if cnt[k] == 2])