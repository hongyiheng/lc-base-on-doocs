# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        nums1, nums2 = [], []
        while l1:
            nums1.append(l1.val)
            l1 = l1.next
        while l2:
            nums2.append(l2.val)
            l2 = l2.next
        a = b = 0
        while nums1:
            a = a * 10 + nums1.pop()
        while nums2:
            b = b * 10 + nums2.pop()
        nums = list(str(a + b))
        ans = ListNode()
        tmp = ans
        while nums:
            tmp.next = ListNode(int(nums.pop()))
            tmp = tmp.next
        return ans.next