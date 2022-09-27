class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        n, m = len(nums), len(l)
        ans = [True] * m
        for i in range(m):
            left, right = l[i], r[i]
            max_, min_ = float('-inf'), float('inf')
            s = set()
            for j in range(left, right + 1):
                s.add(nums[j])
                max_ = max(max_, nums[j])
                min_ = min(min_, nums[j])
            if (max_ - min_) % (right - left) != 0:
                ans[i] = False
                continue
            k = (max_ - min_) // (right - left)
            while min_ < max_:
                if min_ + k not in s:
                    ans[i] = False
                    break
                min_ += k
        return ans
