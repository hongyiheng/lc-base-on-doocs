class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        cnt = k
        for v in nums:
            if v == 1:
                if cnt >= k:
                    cnt = 0
                else:
                    return False
            else:
                cnt += 1
        return True