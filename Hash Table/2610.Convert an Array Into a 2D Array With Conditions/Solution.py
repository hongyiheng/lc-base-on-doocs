class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        cnt = Counter(nums)
        ans = []
        while cnt:
            row = []
            del_k = []
            for k in cnt.keys():
                row.append(k)
                cnt[k] = cnt[k] - 1
                if cnt[k] == 0:
                    del_k.append(k)
            for k in del_k:
                cnt.pop(k)
            ans.append(row)
        return ans