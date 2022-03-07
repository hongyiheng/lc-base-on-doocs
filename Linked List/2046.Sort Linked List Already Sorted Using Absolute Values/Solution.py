# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortLinkedList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        tmp = head
        while tmp and tmp.next:
            if tmp.next.val < 0:
                node = tmp.next
                tmp.next = tmp.next.next
                node.next = dummy.next
                dummy.next = node
            else:
                tmp = tmp.next
        return dummy.next