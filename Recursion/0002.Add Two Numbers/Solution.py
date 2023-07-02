# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode], carry=False) -> Optional[ListNode]:
        if not l1 and not l2:
            return ListNode(1) if carry else None
        if not l1:
            l1, l2 = l2, l1
        v = 1 if carry else 0
        v += l1.val
        v += l2.val if l2 else 0
        l1.val = v % 10
        l1.next = self.addTwoNumbers(l1.next, l2.next if l2 else None, v >= 10)
        return l1