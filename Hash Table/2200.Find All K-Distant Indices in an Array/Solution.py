class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        ans = set()
        for i, v in enumerate(nums):
            if v != key:
                continue
            for j in range(max(0, i - k), min(len(nums), i + k + 1)):
                ans.add(j)
        return list(ans)