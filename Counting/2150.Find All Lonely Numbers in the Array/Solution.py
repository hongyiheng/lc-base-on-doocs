class Solution:
    def findLonely(self, nums: List[int]) -> List[int]:
        cnt = {}
        for v in nums:
            cnt[v] = cnt.get(v, 0) + 1
        ans = []
        for v in nums:
            if cnt.get(v, 0) == 1:
                if (v - 1) not in cnt and (v + 1) not in cnt:
                    ans.append(v)
        return ans