# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        t = dummy
        s = 0
        while head:
            if head.val == 0 and s:
                t.next = ListNode(s)
                t = t.next
                s = 0
            s += head.val
            head = head.next
        return dummy.next
