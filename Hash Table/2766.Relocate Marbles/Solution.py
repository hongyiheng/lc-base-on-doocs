class Solution:
    def relocateMarbles(self, nums: List[int], moveFrom: List[int], moveTo: List[int]) -> List[int]:
        ans = set(nums)
        for u, v in zip(moveFrom, moveTo):
            ans.remove(u)
            ans.add(v)
        return sorted(ans)
