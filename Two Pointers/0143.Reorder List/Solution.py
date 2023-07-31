# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        cur = slow.next
        slow.next = pre = None
        while cur:
            tmp = cur.next
            cur.next = pre
            pre, cur = cur, tmp

        cur = head
        while pre:
            tmp = pre.next
            pre.next = cur.next
            cur.next = pre
            cur, pre = pre.next, tmp