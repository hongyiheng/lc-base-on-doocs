class FindSumPairs:

    def __init__(self, nums1: List[int], nums2: List[int]):
        self.cnt1 = Counter(nums1)
        self.cnt2 = Counter(nums2)
        self.nums2 = nums2

    def add(self, index: int, val: int) -> None:
        self.cnt2[self.nums2[index]] -= 1
        self.nums2[index] += val
        self.cnt2[self.nums2[index]] += 1

    def count(self, tot: int) -> int:
        ans = 0
        for k in self.cnt1.keys():
            if k >= tot:
                continue
            ans += self.cnt1[k] * self.cnt2.get(tot - k, 0)
        return ans

# Your FindSumPairs object will be instantiated and called as such:
# obj = FindSumPairs(nums1, nums2)
# obj.add(index,val)
# param_2 = obj.count(tot)