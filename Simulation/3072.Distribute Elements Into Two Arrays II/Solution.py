class Solution:
    def resultArray(self, nums: List[int]) -> List[int]:
        res1, res2, q1, q2 = [nums[0]], [nums[1]], [nums[0]], [nums[1]]
        for i in range(2, len(nums)):
            v = nums[i]
            idx1, idx2 = bisect.bisect_right(q1, v), bisect.bisect_right(q2, v)
            m, n = len(q1), len(q2)
            if m - idx1 == n - idx2:
                if m <= n:
                    res1.append(v)
                    q1.insert(idx1, v)
                else:
                    res2.append(v)
                    q2.insert(idx2, v)
            elif m - idx1 > n - idx2:
                res1.append(v)
                q1.insert(idx1, v)
            else:
                res2.append(v)
                q2.insert(idx2, v)
        return res1 + res2