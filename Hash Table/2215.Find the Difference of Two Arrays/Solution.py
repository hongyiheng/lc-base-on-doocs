class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        cnt1, cnt2 = [0] * 2001, [0] * 2001
        for v in nums1:
            cnt1[v + 1000] += 1
        for v in nums2:
            cnt2[v + 1000] += 1
        diff1, diff2 = [], []
        for i in range(2001):
            if cnt1[i] != 0 and cnt2[i] == 0:
                diff1.append(i - 1000)
            if cnt2[i] != 0 and cnt1[i] == 0:
                diff2.append(i - 1000)
        return [diff1, diff2]