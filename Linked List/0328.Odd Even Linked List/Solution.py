# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        odd, even = ListNode(), ListNode()
        o, e = odd, even
        index = 1
        while head:
            if index % 2 == 0:
                e.next = head
                e = e.next
            else:
                o.next = head
                o = o.next
            head = head.next
            index += 1
        o.next = even.next
        e.next = None
        return odd.next