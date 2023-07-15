class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        use = set()
        for a in range(n):
            for b in range(a + 1, n):
                t = target - nums[a] - nums[b]
                c, d = b + 1, n - 1
                while c < d:
                    v = nums[c] + nums[d]
                    if v > t:
                        d -= 1
                    elif v < t:
                        c += 1
                    else:
                        arr = [nums[a], nums[b], nums[c], nums[d]]
                        if str(arr) not in use:
                            ans.append(arr)
                            use.add(str(arr))
                        c += 1
                        d -= 1
        return ans