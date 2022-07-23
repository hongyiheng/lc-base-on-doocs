class Solution:
    def sequenceReconstruction(self, nums: List[int], sequences: List[List[int]]) -> bool:
        s = set()
        for v in sequences:
            for i in range(1, len(v)):
                s.add((v[i - 1] << 14) | v[i])
        for i in range(1, len(nums)):
            t = (nums[i - 1] << 14) | nums[i]
            if t not in s:
                return False
        return True