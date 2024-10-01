class Solution:
    def canThreePartsEqualSum(self, arr: List[int]) -> bool:
        s = sum(arr)
        if s % 3:
            return False
        t = s // 3
        cur = cnt = 0
        for v in arr:
            cur += v
            if cur == t:
                cur = 0
                cnt += 1
        return cnt >= 3
