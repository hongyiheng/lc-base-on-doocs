class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        ans = [0] * 2 * n
        l, r, idx = 0, n, 0
        while idx < 2 * n:
            ans[idx] = nums[l]
            ans[idx + 1] = nums[r]
            idx += 2
            l += 1
            r += 1
        return ans