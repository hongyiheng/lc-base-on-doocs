# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head:
            return head
        ans = head
        cur = head.val
        while head and head.next:
            if head.next.val == cur:
                head.next = head.next.next
                continue
            cur = head.next.val
            head = head.next
        return ans