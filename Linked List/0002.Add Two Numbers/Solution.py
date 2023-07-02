# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        tmp = dummy
        carry = False
        while l1 or l2:
            v = 1 if carry else 0
            if l1:
                v += l1.val
                l1 = l1.next
            if l2:
                v += l2.val
                l2 = l2.next
            carry = v >= 10
            tmp.next = ListNode(v % 10)
            tmp = tmp.next
        if carry:
            tmp.next = ListNode(1)
        return dummy.next