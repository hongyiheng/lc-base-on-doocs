# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        ans = ListNode()
        while head and head.val == val:
            head = head.next
        ans = head
        while head and head.next:
            if head.next.val == val:
                head.next = head.next.next
                continue
            head = head.next
        return ans