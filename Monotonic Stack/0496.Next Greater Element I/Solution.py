class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stk = deque()
        mp = dict()
        for v in nums2:
            while stk and stk[-1] < v:
                mp[stk.pop()] = v
            stk.append(v)
        ans = []
        for v in nums1:
            ans.append(mp.get(v, -1))
        return ans