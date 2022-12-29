class Solution:
    def twoOutOfThree(self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        s1, s2, s3 = set(nums1), set(nums2), set(nums3)
        ans = set()
        for v in s1 & s2:
            ans.add(v)
        for v in s1 & s3:
            ans.add(v)
        for v in s2 & s3:
            ans.add(v)
        return list(ans)
